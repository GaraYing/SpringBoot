package com.gara.springbootjdbcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gara")
public class SpringBootJdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcDemoApplication.class, args);
//        SpringApplication.setWebApplicationType(WebApplicationType.REACTIVE);
    }

}

