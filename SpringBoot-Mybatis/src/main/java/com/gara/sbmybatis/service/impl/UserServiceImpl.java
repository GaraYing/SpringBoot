package com.gara.sbmybatis.service.impl;

import com.gara.sbcommon.result.Result;
import com.gara.sbcommon.result.ResultGenerator;
import com.gara.sbmybatis.core.AbstractService;
import com.gara.sbmybatis.entity.User;
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
        return ResultGenerator.genSuccessResult(user.getId());
    }

    @Override
    public Result<User> queryUser(Long id) {
        return ResultGenerator.genSuccessResult(this.findById(id));
    }
}
