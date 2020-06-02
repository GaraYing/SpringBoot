package com.gara.sb.bootstrap;

import com.gara.sb.anntation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description: ConditionalBootStrap引导类 {@link EnableHelloWorld}
 * @author:  GaraYing
 * @createTime: 2020/5/26 9:31
 * @Version: 1.0
**/
@EnableAutoConfiguration
public class EnableAutoConfigurationBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(helloWorld);
        context.close();
    }
}
