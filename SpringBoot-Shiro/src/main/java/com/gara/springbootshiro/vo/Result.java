package com.gara.springbootshiro.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

    private Boolean success = false;

    private String message;

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
