package com.gara.sb_demo7.web;

import com.gara.sb_demo7.vo.User2;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User2,Long> {

    /**
     *
     * 通过用户名获取用户对象
     * @author Gary
     * @date 2018/3/28 14:24
     * @param [username]
     * @return
     * @else
     *
     */
    User2 findByUsername(String username);
}
