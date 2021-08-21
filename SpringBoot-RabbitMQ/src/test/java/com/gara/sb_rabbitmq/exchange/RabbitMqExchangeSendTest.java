package com.gara.sb_rabbitmq.exchange;

import com.rabbitmq.client.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.nio.charset.StandardCharsets;

public class RabbitMqExchangeSendTest {

    private static final String TASK_QUEUE_NAME = "task_queue";
    private static final String EXCHANGE_NAME = "logs";
    private static final String ROUTING_KEY = "";

    @Test
    public void testSend() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setUsername("springboot");
        factory.setPassword("123456");
        RabbitProperties rabbitProperties = new RabbitProperties();
        factory.setHost(rabbitProperties.getHost());
        factory.setPort(rabbitProperties.getPort());
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            // 申明广播类型的交换机
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            String message = "********* Hello World from the fanout exchange *********";
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

    public static void main(String[] args) throws Exception {
        RabbitProperties rabbitProperties = new RabbitProperties();
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setUsername("springboot");
        factory.setPassword("123456");
        factory.setHost(rabbitProperties.getHost());
        factory.setPort(rabbitProperties.getPort());
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 申明广播类型的交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        // binding fanout exchange will ignore the routing_key
        channel.queueBind(queueName, EXCHANGE_NAME, ROUTING_KEY);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}
