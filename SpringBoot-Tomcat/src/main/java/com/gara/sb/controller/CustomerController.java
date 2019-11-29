package com.gara.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;

/**
 * @author GARA
 */

@Controller
public class CustomerController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("Controller");
        return "index";
    }

    @RequestMapping("/map")
    public Map<String, Object> map(){
        System.out.println("Map");
        Map<String, Object> map = Collections.singletonMap("ds", "ssdsd");
        return map;
    }

}
