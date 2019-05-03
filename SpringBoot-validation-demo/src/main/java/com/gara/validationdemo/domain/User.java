package com.gara.validationdemo.domain;

import com.gara.validationdemo.validation.constraints.ValidCardNum;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class User {

    @Max(value = 10000)
    private Long id;

    @NotNull(message = "姓名不能为空")
    private String name;

    @NotNull
//    @ValidCardNum(message = "卡号必须以\"GARA\"开头 , 以数字结尾")
    @ValidCardNum
    private String cardNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
