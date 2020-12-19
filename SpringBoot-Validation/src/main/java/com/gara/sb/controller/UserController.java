package com.gara.sb.controller;

import com.gara.sb.domain.User;
import com.gara.sb.validation.ValidList;
import com.gara.sb.validation.constraints.ListMaxSizeConstraint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@Api(value = "用户控制器", tags = "用户")
@Slf4j
@Validated
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

    @PostMapping("test/list/object")
    public Object testListObjectInController(@Validated @RequestBody /*@NotEmpty(message = "请求参数集合不能为空")*/ @ListMaxSizeConstraint(maxSize = 2) ValidList<User> users){
        log.info("test Object List In Controller passed!");
        return users;
    }
}
