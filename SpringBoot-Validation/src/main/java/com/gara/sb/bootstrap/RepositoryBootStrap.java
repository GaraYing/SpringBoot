package com.gara.sb.bootstrap;

import com.gara.sb.repository.UserRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.gara.sb.repository")
//@EnableAutoConfiguration
public class RepositoryBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        UserRepository userRepository = context.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository);
        context.close();
    }
}
