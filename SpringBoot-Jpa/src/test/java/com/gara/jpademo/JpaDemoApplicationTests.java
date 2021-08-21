package com.gara.jpademo;

import com.gara.jpademo.model.UserInfo;
import com.gara.jpademo.model.UserRole;
import com.gara.jpademo.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

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
                .password("yyyy")
                .qq("122121222212")
                .realname("zhangsna")
                .usertype("AA")
                .build();
        UserInfo userInfo = userInfoRepository.save(info);

        UserInfo userInfoBack = userInfoDao.selectByPrimaryKey(userInfo.getId());

        System.out.println("+++++++++++++userInfoBack: " + userInfoBack.toString());

        UserRole userRole = UserRole.builder().userInfo(userInfo).userroles("admin;customer").build();
        userRoleDao.insert(userRole);

        userInfoRepository.findById(userInfo.getId()).ifPresent(System.out::print);

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
    public void testUnion() throws InterruptedException {
        List<UserInfo> test8 = userInfoRepository.findByUserName("test8");

        test8.forEach(e ->{
            System.out.println(e.getId());
            System.out.println(e.getUserRoles());
        });

        Thread.sleep(5000);
    }

    @Test
    public void testQueryByExample(){
        UserRole userRole = UserRole.builder().id(2).build();
        Example<UserRole> example = Example.of(userRole);
        Optional<UserRole> optional = userRoleExampleRepository.findOne(example);
        Assertions.assertTrue(optional.isPresent());
    }

}
