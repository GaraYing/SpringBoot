package com.gara.validationdemo.controller;

import com.gara.validationdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

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
    public String testSuperBuilder(){
        customerService.testSuperBuilder();
        return "success";
    }

    public static void main(String[] args) {

//        List<String> list = Arrays.asList("12", "23", "34");
        List<String> list1 = new ArrayList<>();
//        list.forEach(System.out::println);
        list1.forEach(System.out::println);
    }
}
