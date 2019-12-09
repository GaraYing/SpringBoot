package com.gara.sb.controller;

import com.gara.sb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @createTime: 2019-10-08 10:13
 * @Version: 4.0
 **/
@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("testSuperBuilder")
    public String testSuperBuilder() {
        customerService.testSuperBuilder();
        return "success";
    }

    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        String s = CompletableFuture.supplyAsync(CustomerController::hello)
                .thenCombine(
                        CompletableFuture.supplyAsync(
                                CustomerController::world), (s1, s2) -> s1 + " " + s2).join();
        System.out.println(s);
        System.out.println(System.currentTimeMillis() - currentTimeMillis + "ms");
    }

    private static String hello(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }

    private static String world(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "world";
    }
}
