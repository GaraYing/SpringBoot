package com.gara.sb.bootstrap;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplicationEventBootstrap {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.refresh();

        context.addApplicationListener(event -> {
            System.out.println("收到事件: " + event);
        });

        context.publishEvent("HelloWorld");
        context.publishEvent("20200620");

        context.publishEvent(new ApplicationEvent("Hello 你好") {

        });


        context.close();
    }
}
