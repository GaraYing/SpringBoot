package com.gara.sbmybatis.controller;

import com.gara.sbcommon.result.Result;
import com.gara.sbmybatis.entity.User;
import com.gara.sbmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Long> addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(value = "detail/{id}")
    public Result<User> addUser(@PathVariable Long id){
        return userService.queryUser(id);
    }

    private static volatile int count = 0;


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            executorService.submit(()->{
                System.out.println(Thread.currentThread() + "==========");
                ++count;
            });
        }

        executorService.shutdown();

        System.out.println(count);
    }
}
