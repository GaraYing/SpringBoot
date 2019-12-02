package com.gara.sbmybatis.config;

import com.gara.sbmybatis.interceptor.CryptInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 核心配置
 */

@Configuration
public class CoreConfig {

    @Bean
    public CryptInterceptor  cryptInterceptor(){
        return new CryptInterceptor();
    }
}
