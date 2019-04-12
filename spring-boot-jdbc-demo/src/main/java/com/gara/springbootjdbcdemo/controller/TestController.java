package com.gara.springbootjdbcdemo.controller;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: TestController
 * @description: 测试
 * @author: GaraYing
 * @create: 2018-12-14 10:23
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/test")
@Api(value = "SwaggerTest", description = "测试相关")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @PostMapping("sysHi/{name}")
    @ApiOperation(value = "测试方法",notes = "测试")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @ApiImplicitParam(name="name", value = "姓名" , required = true, dataType = "String")
    public String sayHi(@PathVariable("name") String name){
        return "Hello" + name;
    }

    @RequestMapping(value = "sysHello",method = RequestMethod.POST)
    @ApiOperation(value = "测试方法",notes = "测试2")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @ApiImplicitParam(name="username", value = "用户姓名" , required = true, dataType = "String")
    public String sayHello(String username){
        return "Hello" + username;
    }

    @ApiOperation(value = "测试方法",notes = "测试3")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @ApiImplicitParam(name="msg", value = "测试消息" , required = true, dataType = "String")
    @GetMapping("/{msg}")
    public String getMsg(@PathVariable("msg") String msg){
        return "你好" + msg;
    }
}
