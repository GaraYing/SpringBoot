package com.gara.sbmybatis.service.impl;

import com.gara.sbmybatis.core.AbstractService;
import com.gara.sbmybatis.entity.User;
import com.gara.sbmybatis.result.Result;
import com.gara.sbmybatis.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户信息实现类
 */

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User, Long> implements UserService {

    @Override
    public Result<Long> saveUser(User user) {
        this.save(user);
        return null;
    }
}
