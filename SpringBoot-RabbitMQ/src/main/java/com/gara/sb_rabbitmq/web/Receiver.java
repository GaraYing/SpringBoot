package com.gara.sb_rabbitmq.web;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * 消息消费者
 * @author Gary
 * @date 2018/04/04 17:38
 */

@Component
public class Receiver {

//    @Autowired
//    private AmqpTemplate rabbitTemplate;

    @RabbitHandler
    @RabbitListener(queues = "hello")
    public void process(String hell0){
        System.out.println("Receiver: " + hell0);
    }
}
