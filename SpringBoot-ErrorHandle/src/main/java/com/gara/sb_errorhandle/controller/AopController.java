package com.gara.sb_errorhandle.controller;

import com.gara.sb_errorhandle.result.Result;
import com.gara.sb_errorhandle.result.ResultCode;
import com.gara.sb_errorhandle.result.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @description: TODO AOP控制器
 * @author: Gara
 * @createTime: 2019-07-12 17:53
 * @Version: 1.0
 **/
@Slf4j
@Aspect
@Component
public class AopController {

    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        Result<?> result;

        try {
            result = (Result<?>) pjp.proceed();
            log.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }

        return result;
    }

    private Result<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result<?> result = ResultGenerator.genSuccessResult();

        // 已知异常
        if (e instanceof RuntimeException) { // 自定有异常
            result.setMessage(e.getLocalizedMessage());
            result.setCode(ResultCode.FAIL);
        } else {
            log.error(pjp.getSignature() + " error ", e);

            result.setMessage(e.toString());
            result.setCode(ResultCode.FAIL);

            // 未知异常是应该重点关注的，这里可以做其他操作，如通知邮件，单独写到某个文件等等。
        }

        return result;
    }
}
