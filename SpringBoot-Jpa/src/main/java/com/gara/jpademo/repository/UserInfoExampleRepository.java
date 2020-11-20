package com.gara.jpademo.repository;

import com.gara.jpademo.model.UserInfo;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserInfoExampleRepository extends QueryByExampleExecutor<UserInfo> {

}