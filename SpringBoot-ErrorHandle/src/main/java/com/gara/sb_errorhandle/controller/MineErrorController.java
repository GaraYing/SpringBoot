package com.gara.sb_errorhandle.controller;

import com.gara.sbcommon.result.Result;
import com.gara.sbcommon.result.ResultGenerator;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: TODO
 * @author: GaraYing
 * @create: 2018-08-16 17:08
 **/

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class MineErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    /**
     * {"code":-1,"msg":"网络异常，请稍后重试","data":null}
     * @return
     */
    @RequestMapping
    @ResponseBody
    public Result doHandleError() {
        return ResultGenerator.genFailResult("FAIL");
    }

    @ExceptionHandler(Exception.class)
    public Result handleException() {
        return ResultGenerator.genFailResult("FAIL");
    }
}
