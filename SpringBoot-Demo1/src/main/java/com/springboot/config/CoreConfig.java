package com.springboot.config;

import com.springboot.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @description: 核心配置类
 * @author:  Gara
 * @createTime: 2019/12/30 14:15 
 * @Version: 1.0
**/
@Configuration
public class CoreConfig {


    @Autowired
    Environment env;

    @Bean
    public User user(){
        User user = new User();
        user.setName(env.getProperty("com.springboot.vo.User"));
        return user;
    }
}
