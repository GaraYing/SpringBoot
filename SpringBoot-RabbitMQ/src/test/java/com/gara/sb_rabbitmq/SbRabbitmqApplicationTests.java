package com.gara.sb_rabbitmq;

import com.gara.sb_rabbitmq.service.MyAbstractRabbitMqService;
import com.gara.sb_rabbitmq.web.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class SbRabbitmqApplicationTests {

    @Autowired
    private Sender sender;

    @Value("${rabbit.exchange}")
    private String exchange;

    @Test
    public void hello() throws Exception {
        sender.send();
    }

    @Autowired
    private MyAbstractRabbitMqService myRabbitMqService;

    @Test
    public void testSendMsg(){
        myRabbitMqService.sendMessage("hello.world", "This is  a test Msg: " + new Date());
    }

}
