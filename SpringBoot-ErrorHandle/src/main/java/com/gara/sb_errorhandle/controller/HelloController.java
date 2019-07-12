package com.gara.sb_errorhandle.controller;

/**
 * @description:
 * @createTime: 2019-07-12 18:11
 * @Version: 4.0
 **/

import com.gara.sb_errorhandle.annotation.Action;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    @Action("hello")
    public String hello() {
        return "Hello Spring Boot";
    }
}
