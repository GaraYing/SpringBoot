package com.gara.sb_errorhandle.controller;

/**
 * @description: 返回结果集
 * @author: GaraYing
 * @create: 2018-08-16 17:31
 **/

public class Result<T> {

    private int code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(ResultCode resultCode, T data) {
        this(resultCode);
        this.data = data;
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
