package com.gara.springbootjdbcdemo.test;

import com.gara.sbcommon.CommonConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author GARA
 * @Title: TestConfig
 * @Description:
 * @date 2019/4/11 23:18
 */
@Configuration
@Import(CommonConfig.class)
public class TestConfig {

    @Value("${test.oss:ali}")
    private String testOss;

    public static String SS;

    public String getTestOss() {
        return testOss;
    }

    public void setTestOss(String testOss) {
        this.testOss = testOss;
    }

    @Value("${test.sv:test}")
    public void setSS(String SS) {
        TestConfig.SS = SS;
    }
}
