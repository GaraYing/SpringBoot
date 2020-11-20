package com.gara.jpademo;

import com.gara.jpademo.model.UserInfo;
import com.gara.jpademo.model.UserRole;
import com.gara.jpademo.repository.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@MapperScan(basePackages = "com.gara.jpademo")
@SpringBootTest

public class JpaDemoApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserInfoExampleRepository userInfoExampleRepository;
    @Autowired
    private UserRoleExampleRepository userRoleExampleRepository;

    @Test
    public void testConn(){
        UserInfo info = UserInfo.builder().userName("test7")
                .email("test7@qq.com")
                .password("xxxxx")
                .qq("122121212")
                .realname("zhangsna")
                .usertype("qq")
                .build();
        UserInfo userInfo = userInfoRepository.save(info);

        UserInfo userInfoBack = userInfoDao.selectByPrimaryKey(userInfo.getId());

        System.out.println(userInfoBack.toString());

        UserRole userRole = UserRole.builder().userName("test1").userroles("admin;customer").build();
        userRoleDao.insert(userRole);

        UserRole userRole1 = userRoleDao.selectByPrimaryKey(userRole.getId());
        System.out.println(userRole1);
    }

    @Test
    public void testPage(){
        Page<UserInfo> page = userInfoRepository.findAll(PageRequest.of(1,2));
        List<UserInfo> list = userInfoRepository.findAllByUserName("test3", PageRequest.of(0, 2, Sort.by("id").descending().and(Sort.by("userName").ascending())));
        System.out.println("list: " + list);
        System.out.println("page: " + page.getContent());
    }

    @Test
    public void testUnion(){

    }

    @Test
    public void testQueryByExample(){
//        UserInfo userInfo = UserInfo.builder().userName("test1").build();
//
//        Example<UserInfo> example = Example.of(userInfo);
//
//        int integer = userInfoExampleRepository.findOne(example).map(UserInfo::getId).orElse(0);
//
//
//        Assert.assertEquals(1, integer);

        UserRole userRole = UserRole.builder().userName("test1").build();

        Example<UserRole> example = Example.of(userRole);

        userRoleExampleRepository.findOne(example);

    }

}
