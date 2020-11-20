package com.gara.jpademo.service;

import com.gara.jpademo.config.CommonConfig;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service
@Import(CommonConfig.class)
public class TestBean {

    public TestBean() {
        System.out.println("*************** testBean constructed ***************");
    }
}
