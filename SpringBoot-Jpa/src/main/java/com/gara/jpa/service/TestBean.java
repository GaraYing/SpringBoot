package com.gara.jpa.service;

import com.gara.jpa.config.CommonConfig;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service
@Import(CommonConfig.class)
public class TestBean {

    public TestBean() {
        System.out.println("*************** testBean constructed ***************");
    }
}
