package com.gara.sb.bootstrap;

import com.gara.sb.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description: ProfileBootStrap引导类 {@link org.springframework.context.annotation.Profile}
 * @author: GaraYing
 * @createTime: 2020/5/25 16:42
 * @Version: 1.0
 **/

@ComponentScan(basePackages = "com.gara.sb.service")
public class ProfileBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ProfileBootStrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);

        CalculateService calculateService = context.getBean(CalculateService.class);

        System.out.println("CalculateService with Profile Java8: " + calculateService.sum(0, 1, 2, 3, 4, 5));

        context.close();

    }
}
