package com.gara.sb.bootstrap;

import com.gara.sb.condition.ConditionalOnSystemProperty;
import com.gara.sb.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @description: ProfileBootStrap引导类 {@link org.springframework.context.annotation.Profile}
 * @author: GaraYing
 * @createTime: 2020/5/25 16:42
 * @Version: 1.0
 **/

public class ConditionalBootStrap {


    @ConditionalOnSystemProperty(name = "user.name", value = "administrator")
    @Bean
    public String syaHi(){
        return "Hello from sayHi()";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalBootStrap.class)
                .web(WebApplicationType.NONE)
//                .profiles("Java8")
                .run(args);

        String syaHi = context.getBean("syaHi", String.class);

        System.out.println(syaHi);

        context.close();

    }
}
