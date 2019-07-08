package com.gara.test;

import com.gara.mystarter.service.ExampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Autowired
    private ExampleService exampleService;

    @Test
    public void contextLoads() {
        System.out.println("**********");
        System.out.println(exampleService.wrap("-unbelievable-"));
        System.out.println("**********");
    }

}
