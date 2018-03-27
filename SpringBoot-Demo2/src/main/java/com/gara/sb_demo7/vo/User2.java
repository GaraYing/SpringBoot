package com.gara.sb_demo7.vo;

import org.springframework.data.annotation.Id;

public class User2 {

    @Id
    private Long id;


    private String username;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User2(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
}
