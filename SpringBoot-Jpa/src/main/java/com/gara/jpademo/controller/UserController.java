package com.gara.jpademo.controller;

import com.gara.jpademo.model.UserInfo;
import com.gara.jpademo.repository.UserInfoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    public UserInfoRepository repository;

    public UserController(UserInfoRepository repository) {
        this.repository = repository;
    }

    @ResponseBody
    @RequestMapping("user/info/{id}")
    public UserInfo getUserInfo(@PathVariable(value = "id") Integer id){
        UserInfo userInfo = repository.findById(id).get();
        System.out.println("************userRoles: " + userInfo.getUserRoles());
        return userInfo;
    }
}
