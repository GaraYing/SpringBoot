package com.gara.sb_rabbitmq.web.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 小哥哥加点注释吧~~
 *
 * @author Gary
 * @date 2018/04/04 17:41
 */

@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }

    public static String exchange;

    @Value("${rabbit.exchange:exchange.default.test}")
    public void setExchange(String exchange) {
        RabbitConfig.exchange = exchange;
    }
}
