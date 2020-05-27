package com.gara.sb.config;

import com.gara.sb.validation.SamplePropertiesValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;

/**
 * @description: 核心配置类
 * @author:  Gara
 * @createTime: 2019/12/16 10:33
 * @Version: 1.0
**/
@Configuration
//@Import(value = CommonConfig.class)
public class CoreConfig {

    @Bean
    public String helloWorld(){ // 方法名即Bean名
        return "Hello World 2020";
    }

    @Bean
    public Validator configurationPropertiesValidator(){
        return new SamplePropertiesValidator();
    }
}
