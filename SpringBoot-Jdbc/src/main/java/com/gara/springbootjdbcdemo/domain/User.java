package com.gara.springbootjdbcdemo.domain;

/**
 * @ClassName: User
 * @description: 用户实体类
 * @author: GaraYing
 * @create: 2018-12-14 10:26
 * @Version: 1.0
 **/
public class User {
    private Long id;
    private String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
