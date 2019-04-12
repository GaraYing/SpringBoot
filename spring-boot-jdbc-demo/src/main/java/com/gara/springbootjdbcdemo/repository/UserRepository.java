package com.gara.springbootjdbcdemo.repository;

import com.gara.springbootjdbcdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName: UserRepository
 * @description: 用户Repo
 * @author: GARA
 * @create: 2018-12-14 10:19
 * @Version: 1.0
 **/

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    private final ConcurrentMap<Long, User> repository = new ConcurrentHashMap<>();
    // 原子递增
    private AtomicLong idGenerator = new AtomicLong();

    public Boolean save(User user){
        Long id = idGenerator.incrementAndGet();
        return repository.putIfAbsent(id,user) ==  null;
    }

    public Collection<User> findAll(){
        return repository.values();
    }
}
