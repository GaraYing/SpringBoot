package com.springboot.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "id_test")
public class IdTest {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String redisId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRedisId() {
        return redisId;
    }

    public void setRedisId(String redisId) {
        this.redisId = redisId;
    }

    public IdTest(String redisId) {
        this.redisId = redisId;
    }
}
