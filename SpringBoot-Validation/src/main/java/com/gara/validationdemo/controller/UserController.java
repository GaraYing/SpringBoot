package com.gara.validationdemo.controller;

import com.gara.validationdemo.domain.User;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @GetMapping("/test")
    public String test(){
        return  "test";
    }

    /*
        Valid 验证
     */
    @PostMapping("/user/save")
    public User save(@Valid @RequestBody User user){
        // API 调用的方式
        Assert.hasText(user.getName(),"名称不能为空");
        // 断言
        assert user.getId() <=10001;
        return user;
    }
}
