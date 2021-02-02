package com.gara.sb_rabbitmq.web.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @description: RabbitMq生产者配置
 * @author:  GaraYing
 * @createTime: 2021/2/2 10:23 
 * @version: 1.0
**/
@Slf4j
public abstract class AbstractRabbitMqProducerConfiguration implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private final String exchange;

    private final RabbitTemplate rabbitTemplate;

    public AbstractRabbitMqProducerConfiguration(RabbitTemplate rabbitTemplate) {
        this.exchange = RabbitConfig.exchange;
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setExchange(this.exchange);
    }

    public void sendMessage(String exchange, String routingKey, final Object bizMessage, String messageId, final Map<String, Object> headers) {
        String correlationId = messageId;
        if (StringUtils.isBlank(correlationId)) {
            correlationId = UUID.randomUUID().toString();
        }
        if (log.isDebugEnabled()) {
            log.debug("send message correlationId={},exchange={},routingKey={}", correlationId, exchange, routingKey);
        }
        CorrelationData correlationData = new CorrelationData(correlationId);
        final String msgId = correlationId;
        rabbitTemplate.convertAndSend(exchange, routingKey, bizMessage, (msg) -> {
            MessageProperties messageProperties = msg.getMessageProperties();
            messageProperties.setCorrelationId(msgId);
            messageProperties.setMessageId(msgId);
            messageProperties.setTimestamp(new Date());
            if (headers != null) {
                messageProperties.getHeaders().putAll(headers);
            }
            return msg;
        }, correlationData);
    }

    /**
     * 发送消息到默认交换机
     */
    public void sendMessage(String routingKey, final Object bizMessage, String messageId) {
        this.sendMessage(exchange, routingKey, bizMessage, messageId, null);
    }

    /**
     * 发送消息到默认交换机
     */
    public void sendMessage(String routingKey, final Object bizMessage, String messageId, final Map<String, Object> headers) {
        this.sendMessage(exchange, routingKey, bizMessage, messageId, headers);
    }

    /**
     * 发送消息到默认交换机
     */
    public void sendMessage(String routingKey, final Object bizMessage) {
        this.sendMessage(exchange, routingKey, bizMessage, null, null);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            String correlationId = correlationData != null ? correlationData.getId() : "";
            log.error("RabbitMq confirm 回调correlationId={}未发到对应的exchange上，原因={}", correlationId, cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        MessageProperties messageProperties = message.getMessageProperties();
        log.error("RabbitMq returnedMessage 回调correlationId={}未路由到对应的queue上，replyCode={},replyText={},exchange={},routingKey={}",
                messageProperties.getCorrelationId(), replyCode, replyText, exchange, routingKey);
    }
}
