package com.springboot.vo;

import java.io.Serializable;

public class User2 implements Serializable {

    private String userName;

    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User2(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }
}
