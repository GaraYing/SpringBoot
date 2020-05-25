package com.gara.sb.controller;

import com.gara.sb.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "用户控制器", tags = "用户")
public class UserController {


    @ApiOperation(value = "测试")
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
