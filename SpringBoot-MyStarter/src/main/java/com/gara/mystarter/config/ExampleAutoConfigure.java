package com.gara.mystarter.config;

import com.gara.mystarter.properties.ExampleProperties;
import com.gara.mystarter.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 测试自动配置
 * @createTime: 2019-06-24 14:12
 * @Version: 1.0
 **/

@Configuration
@ConditionalOnClass(ExampleService.class)
@EnableConfigurationProperties(ExampleProperties.class)
public class ExampleAutoConfigure {

    /* notes:
        1. @ConditionalOnClass，当classpath下发现该类的情况下进行自动配置。
        2. @ConditionalOnMissingBean，当Spring Context中不存在该Bean时。
        3. @ConditionalOnProperty(prefix = "example.service",value = "enabled",havingValue = "true")，当配置文件中example.service.enabled=true时。
     */

    private final ExampleProperties properties;

    @Autowired
    public ExampleAutoConfigure(ExampleProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "example", value = "enabled", havingValue = "true")
    ExampleService exampleService() {
        return new ExampleService(properties.getPrefix(), properties.getSuffix());
    }

}
