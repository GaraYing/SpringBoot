package com.gara.sb_demo7.web;

import com.gara.sb_demo7.vo.User2;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User2,Long> {

    User2 findByUsername(String username);
}
