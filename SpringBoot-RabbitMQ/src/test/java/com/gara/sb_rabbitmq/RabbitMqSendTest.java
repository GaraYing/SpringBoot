package com.gara.sb_rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.junit.Test;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RabbitMqSendTest {

    public static final String QUEUE_NAME = "hello.world";

    @Test
    public void sendMsgToQueue(){

        RabbitProperties rabbitProperties = new RabbitProperties();
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setUsername("springboot");
        factory.setPassword("123456");
        factory.setHost(rabbitProperties.getHost());
        factory.setPort(rabbitProperties.getPort());
        String msg = "hello World";
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicPublish("", "hello.world",null , msg.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + msg + "'");
            // 关闭通道/连接
//            channel.close();
//            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
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
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
            // requeue all unacknowledged deliveries up to
            // this delivery tag
            channel.basicNack(delivery.getEnvelope().getDeliveryTag(), true, true);
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {

        });
    }

}
