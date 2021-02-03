package com.gara.sb_rabbitmq.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.nio.charset.StandardCharsets;

public class Consumer {

    private static final String EXCHANGE_NAME = "logs";

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
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}
