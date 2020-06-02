package com.gara.sb.config;

import com.gara.sb.anntation.EnableHelloWorld;
import com.gara.sb.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @description: HelloWorld 自动装配
 * @author:  GaraYing
 * @createTime: 2020/6/1 19:34
 * @Version: 1.0
**/

@Configuration
@EnableHelloWorld
@ConditionalOnSystemProperty(name = "user.name", value = "yingz")
public class HelloWorldAutoConfiguration {

}
