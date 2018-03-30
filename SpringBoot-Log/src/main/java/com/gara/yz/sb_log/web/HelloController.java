package com.gara.yz.sb_log.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 小哥哥加点注释吧~~
 *
 * @author Gary
 * @date 2018/03/28 17:14
 */

@Controller
public class HelloController {

    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "hello " + name;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hi")
    public String hi(){
        return "hi";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
