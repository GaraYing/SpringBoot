package com.springboot.vo;

import javax.persistence.Id;

public class User3 {

    @Id
    private Long id;

    private String userName;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public User3(Long id, String userName, Integer age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }
}
