package com.gara.springbootjdbcdemo.repository;

import com.gara.springbootjdbcdemo.SpringBootJdbcDemoApplicationTests;
import com.gara.springbootjdbcdemo.exception.CustomDuplicateKeyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserRepositoryTest extends SpringBootJdbcDemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    // public UserRepositoryTest(UserRepository userRepository) {
    //     this.userRepository = userRepository;
    // }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void findAll() {
        System.out.println(userRepository.findAll());
    }

    @Test
    public void testCustomSqlErrorCodeException(){
        Assertions.assertThrows(CustomDuplicateKeyException.class, ()-> {
            jdbcTemplate.execute("insert into user_info (id, username, password, usertype, enabled, realname, qq, email, tel)\n" +
                    "values (0,'zhangsan33','121312',1,1,'lisi','121','121@232.com','123123123123')");
            jdbcTemplate.execute("insert into user_info (id, username, password, usertype, enabled, realname, qq, email, tel)\n" +
                    "values (0,'zhangsan33','121312',1,1,'lisi','121','121@232.com','123123123123')");
        },"c message print");
    }
}