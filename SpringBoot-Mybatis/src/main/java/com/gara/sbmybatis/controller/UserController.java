package com.gara.sbmybatis.controller;

import com.gara.sbmybatis.entity.User;
import com.gara.sbmybatis.result.Result;
import com.gara.sbmybatis.result.ResultGenerator;
import com.gara.sbmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息控制器类
 */

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "add")
    public Result addUser(User user){
        userService.save(user);
        return ResultGenerator.genSuccessResult(user.getId());
    }
}
