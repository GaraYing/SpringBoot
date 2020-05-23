package com.gara.springbootjdbcdemo.test;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author GARA
 * @Title: ConfigTest
 * @Description:
 * @date 2019/4/11 23:25
 */
@Component
public class ConfigTest implements InitializingBean {

    @Autowired
    private TestConfig config;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(config.getTestOss()+"1");

        System.out.println(TestConfig.SS + "2");
    }
}
