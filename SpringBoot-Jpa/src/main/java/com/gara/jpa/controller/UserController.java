package com.gara.jpa.controller;

import com.gara.jpa.model.UserInfo;
import com.gara.jpa.repository.UserInfoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class UserController {

    public UserInfoRepository repository;

    public UserController(UserInfoRepository repository) {
        this.repository = repository;
    }

    @ResponseBody
    @RequestMapping("user/info/{id}")
    public UserInfo getUserInfo(@PathVariable(value = "id") Integer id){
        UserInfo userInfo = repository.findById(id).orElse(null);
//        System.out.println("************userRoles: " +  userInfo.getUserRoles());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            Iterable<UserInfo> all = repository.findAll();
            all.forEach(e->System.out.println(e.getId()));
        });
        return userInfo;
    }

    @ResponseBody
    @GetMapping(value = "test/get", consumes = "application/json")
    public Object testGetWithBody(@RequestBody Object userInfo){
        System.out.println(userInfo);
        return userInfo;
    }

    @ResponseBody
    @PostMapping(value = "test/list")
    public Object testGetWithBody(@RequestBody @Valid @NotEmpty(message = "不能为空") List<Object> list){
        System.out.println(list);
        return list;
    }
}
