package com.gara.springbootjdbcdemo.controller;

import com.gara.springbootjdbcdemo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @description: 用户信息控制器
 * @createTime: 2019-07-27 10:46
 * @Version: 1.0.4
 **/
@RestController
@RequestMapping("users")
public class UserInfoController {
    @GetMapping("user")
    public Mono<User> getUser(@PathVariable Long user) {
        return null;
    }
}
