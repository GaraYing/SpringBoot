package com.gara.springbootjdbcdemo.controller;

import com.gara.springbootjdbcdemo.domain.Customer;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * @ClassName: TestController
 * @description: 测试
 * @author: GaraYing
 * @create: 2018-12-14 10:23
 * @Version: 1.0
 **/
@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    public Boolean getUser(){
        return true;
    }
}
