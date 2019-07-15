package com.gara.springbootjdbcdemo.controller;

import com.gara.springbootjdbcdemo.domain.User;
import com.gara.springbootjdbcdemo.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @ClassName: UserController
 * @description: 用户Controller
 * @author: GARAYing
 * @create: 2018-12-14 10:21
 * @Version: 1.0
 **/
@RestController
@RequestMapping("users")
@Api(value = "userTest", description = "用户测试相关")
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
    @ApiOperation(value = "测试方法用户",notes = "测试4")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @ApiImplicitParam(name="name", value = "用户姓名" , required = true, dataType = "String")
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public Boolean save(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }

    @ApiOperation(value = "测试方法用户",notes = "测试5")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @RequestMapping(value = "userLists", method = RequestMethod.GET)
    public Collection<User> userLists() {
        return userRepository.findAll();
    }
}
