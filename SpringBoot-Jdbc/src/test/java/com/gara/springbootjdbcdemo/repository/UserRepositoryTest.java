package com.gara.springbootjdbcdemo.repository;

import com.gara.springbootjdbcdemo.SpringBootJdbcDemoApplicationTests;
import org.junit.jupiter.api.Test;


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