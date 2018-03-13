package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO T_USER VALUES (?,?)" ,name,age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE  FROM t_USER WHERE NAME =?",name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from T_USER", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE FROM T_USER");
    }

    @Override
    public void updateUsers(String name, Integer age) {
        jdbcTemplate.update("UPDATE T_USER SET age= ? WHERE name=?",age,name);
    }
}
