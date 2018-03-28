package com.gara.yz.sb_log.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 小哥哥加点注释吧~~
 *
 * @author Gary
 * @date 2018/03/28 17:14
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "hello " + name;
    }

}
