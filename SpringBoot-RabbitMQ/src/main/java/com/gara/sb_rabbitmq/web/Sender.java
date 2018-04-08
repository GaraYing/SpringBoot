package com.gara.sb_rabbitmq.web;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 * 消息生产者
 * @author Gary
 * @date 2018/04/04 17:34
 */

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){

        String context = "hello" + new Date();
        System.out.println("-=-=-=-=-=-=-=-=");
        System.out.println("Sender:" + context);
        System.out.println("-=-=-=-=-=-=-=-=");

        this.rabbitTemplate.convertAndSend("hello",context);
    }
}
