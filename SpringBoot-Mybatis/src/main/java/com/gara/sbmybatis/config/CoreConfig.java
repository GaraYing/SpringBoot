package com.gara.sbmybatis.config;

import com.gara.sbcommon.CommonConfig;
import com.gara.sbmybatis.interceptor.CryptInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 核心配置
 */
@Configuration
@Import(value = CommonConfig.class)
public class CoreConfig {
}
