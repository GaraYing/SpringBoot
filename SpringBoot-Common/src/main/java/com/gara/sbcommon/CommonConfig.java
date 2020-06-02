package com.gara.sbcommon;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @description: common配置类
 * @author:  Gara
 * @createTime: 2019/12/12 15:09
 * @Version: 1.0
**/

//@EnableAutoConfiguration
//@Component
@ComponentScan(basePackageClasses = CommonConfig.class)
public class CommonConfig  implements CommandLineRunner, InitializingBean {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("commonConfig init *********");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("commonConfig init ---------");
    }
}
