package com.springboot.vo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Worker {

    @Id
    @GeneratedValue
    @GenericGenerator(name = "", strategy = "")
    private Integer workerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Worker() {
    }

    public Worker(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
