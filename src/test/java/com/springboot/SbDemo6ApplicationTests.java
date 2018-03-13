package com.springboot;

import com.springboot.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbDemo6ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private UserService userSerivce;

	@Before
	public void setUp() {
		// 准备，清空user表
		userSerivce.deleteAllUsers();
	}

	@Test
	public void test() throws Exception {
		// 插入5个用户
		userSerivce.create("a", 1);
		userSerivce.create("b", 2);
		userSerivce.create("c", 3);
		userSerivce.create("d", 4);
		userSerivce.create("e", 5);

		userSerivce.updateUsers("e", 99);

		// 查数据库，应该有5个用户

		System.out.println("-=========***********=-===");
		Assert.assertEquals(5, userSerivce.getAllUsers().intValue());
		System.out.println("-========***********-=-===");

		// 删除两个用户
		userSerivce.deleteByName("a");
		userSerivce.deleteByName("b");

//		userSerivce.deleteAllUsers();


		// 查数据库，应该有5个用户
		Assert.assertEquals(3, userSerivce.getAllUsers().intValue());

	}

}
