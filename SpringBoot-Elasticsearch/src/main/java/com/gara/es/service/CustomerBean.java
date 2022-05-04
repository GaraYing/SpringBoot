package com.gara.es.service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerBean {

    public CustomerBean() {
        System.out.println("*************** testBean constructed ***************");
    }

    private Long id;

    private String code;

    private String level;

    private String secondLevel;

    private Integer age;

    private Integer sex;

    private String firstName;

    private String lastName;

    private LocalDateTime birthDate;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private String createdBy;

    private String updatedBy;
}
