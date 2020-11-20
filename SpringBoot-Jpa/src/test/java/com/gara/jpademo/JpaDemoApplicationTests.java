package com.gara.jpademo;

import com.gara.jpademo.model.UserInfo;
import com.gara.jpademo.repository.UserInfoDao;
import com.gara.jpademo.repository.UserInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    private UserInfoRepository userInfoRepository;

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

}
