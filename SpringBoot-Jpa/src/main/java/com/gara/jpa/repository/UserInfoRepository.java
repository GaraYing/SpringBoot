package com.gara.jpa.repository;

import com.gara.jpa.model.UserInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserInfoRepository extends CrudRepository<UserInfo, Integer>, PagingAndSortingRepository<UserInfo, Integer> {

    List<UserInfo> findByUserName(String userName);

    List<UserInfo> findAllByUserName(String userName, Pageable pageable);

}