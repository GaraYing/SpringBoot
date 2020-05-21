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

    @Value("${fdd.oss:ali}")
    private String fddOss;

    public static String SS;

    public String getFddOss() {
        return fddOss;
    }

    public void setFddOss(String fddOss) {
        this.fddOss = fddOss;
    }

    @Value("${fdd.sv:test}")
    public void setSS(String SS) {
        TestConfig.SS = SS;
    }
}
