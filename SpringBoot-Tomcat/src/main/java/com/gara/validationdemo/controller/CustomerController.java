package com.gara.validationdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GARA
 */

@Controller
public class CustomerController {

    @RequestMapping("/")
    public String index(){
        System.out.println("Controller");
        return "index";
    }

}
