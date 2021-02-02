package com.gara.sb_rabbitmq.service;

import com.gara.sb_rabbitmq.web.config.AbstractRabbitMqProducerConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyAbstractRabbitMqService extends AbstractRabbitMqProducerConfiguration {

    public MyAbstractRabbitMqService(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate);
    }
}
