package com.gara.sb_errorhandle.result;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 统一API响应结果封装
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 9067908254452061227L;
    private int code;
    private String message;
    private T data;
    private Boolean success;

    public Result<T> setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Result<T> setSuccess(Boolean success){
        this.success = success;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
