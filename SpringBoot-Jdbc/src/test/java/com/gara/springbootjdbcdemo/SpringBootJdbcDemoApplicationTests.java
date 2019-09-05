package com.gara.springbootjdbcdemo;

import com.gara.springbootjdbcdemo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcDemoApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Autowired
    private  UserRepository userRepository;

//    public UserRepositoryTest(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Test
    public void findAll() {
        System.out.println(userRepository.findAll());
    }
}

