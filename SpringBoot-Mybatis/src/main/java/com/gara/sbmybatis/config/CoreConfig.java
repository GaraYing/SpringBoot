package com.gara.sbmybatis.config;

import com.gara.sbcommon.CommonConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 核心配置
 */
@Configuration
@Import(value = CommonConfig.class)
public class CoreConfig implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("coreConfig init *********");
    }
}
