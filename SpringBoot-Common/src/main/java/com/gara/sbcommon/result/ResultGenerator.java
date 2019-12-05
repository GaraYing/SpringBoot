package com.gara.sbcommon.result;

import java.io.Serializable;

/**
 * 响应结果生成工具
 */
public class ResultGenerator implements Serializable {
    private static final long serialVersionUID = 8901604247245247108L;
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setSuccess(Boolean.TRUE)
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result<T>()
                .setSuccess(Boolean.TRUE)
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static <T> Result<T> genSuccessResult(T data,String message) {
        return new Result<T>()
                .setSuccess(Boolean.TRUE)
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setSuccess(Boolean.FALSE)
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    public static Result genResult(ResultCode code, String message) {
        return new Result()
                .setSuccess(Boolean.TRUE)
                .setCode(code)
                .setMessage(message);
    }
}
