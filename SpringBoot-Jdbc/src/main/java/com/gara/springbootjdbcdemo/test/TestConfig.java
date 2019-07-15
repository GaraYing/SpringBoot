package com.gara.springbootjdbcdemo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author GARA
 * @Title: TestConfig
 * @Description:
 * @date 2019/4/11 23:18
 */
@Configuration
public class TestConfig {

    @Value("${fdd.oss}")
    private String fddOss;

    public static String SS;

    public String getFddOss() {
        return fddOss;
    }

    public void setFddOss(String fddOss) {
        this.fddOss = fddOss;
    }

    @Value("${fdd.sv}")
    public void setSS(String SS) {
        TestConfig.SS = SS;
    }
}
