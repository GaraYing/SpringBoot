package com.springboot.controller;

import com.springboot.service.IdTestRepository;
import com.springboot.service.RedisTest;
import com.springboot.vo.IdTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class RedisIdController {

    public static ExecutorService executorService = null;

    public RedisIdController() {
        executorService = Executors.newFixedThreadPool(50);
    }

    @Resource
    private RedisTest redisTest;

    @Resource
    private IdTestRepository idTestRepository;

    @RequestMapping("genId")
    public String genId(){

        String orderId = redisTest.generateOrderId();

        executorService.execute(() -> idTestRepository.save(new IdTest(orderId)));

//        executorService.shutdown();

        return "SUCCESS";
    }
}
