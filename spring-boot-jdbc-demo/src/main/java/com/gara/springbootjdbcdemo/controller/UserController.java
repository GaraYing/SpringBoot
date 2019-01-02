package com.gara.springbootjdbcdemo.controller;

import com.gara.springbootjdbcdemo.domain.User;
import com.gara.springbootjdbcdemo.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @description: 用户Controller
 * @author: GARAYing
 * @create: 2018-12-14 10:21
 * @Version: 1.0
 **/
@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;

    // 注意：这里不需要在方法上添加@Autowired注解，构造方法自动在RestController 实现注入
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     * @Author GaraYing
     * @Description
     * @Date 10:47 2018/12/14
     * @Param [name]
     * @return java.lang.Boolean
     **/
    @RequestMapping("user")
    public Boolean save(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }
}
