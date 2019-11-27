package com.gara.springbootjdbcdemo.repository;

import com.gara.springbootjdbcdemo.SpringBootJdbcDemoApplicationTests;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRepositoryTest extends SpringBootJdbcDemoApplicationTests {

    private final UserRepository userRepository;

    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void findAll() {
        System.out.println(userRepository.findAll());
    }
}