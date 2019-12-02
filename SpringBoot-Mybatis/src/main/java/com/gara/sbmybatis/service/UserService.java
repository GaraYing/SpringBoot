package com.gara.sbmybatis.service;

import com.gara.sbmybatis.core.Service;
import com.gara.sbmybatis.entity.User;
import com.gara.sbmybatis.result.Result;

/**
 * 用户信息接口
 */
public interface UserService extends Service<User, Long> {

    /**
     * @Description //保存用户信息
     * @Param [user]
     * @return com.gara.sbmybatis.result.Result<java.lang.Long>
     * @Date 16:10 2019/12/2
     * @Author GaraYing
     **/
    Result<Long> saveUser(User user);
}
