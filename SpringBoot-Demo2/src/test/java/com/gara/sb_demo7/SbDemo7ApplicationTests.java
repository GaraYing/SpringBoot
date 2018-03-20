package com.gara.sb_demo7;

import com.gara.sb_demo7.vo.User;
import com.gara.sb_demo7.vo.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SbDemo7ApplicationTests {


	@Autowired
	private UserMapper userMapper;

	@Test
//	@Rollback
	public void findByName() {

		userMapper.insert("AA",25);
		User user = userMapper.findByName("AA");
		Assert.assertEquals(25, user.getAge().intValue());

//		Map<String, Object> map = new HashMap<>();
//		map.put("name", "CCC");
//		map.put("age", 40);
//		userMapper.insertByMap(map);

	}

	@Test
	@Rollback
	public void testUserMapper() throws Exception {
		// insert一条数据，并select出来验证
		userMapper.insert("AAA", 20);
		User u = userMapper.findByName("AAA");
		Assert.assertEquals(20, u.getAge().intValue());
		// update一条数据，并select出来验证
		u.setAge(30);
		userMapper.update(u);
		u = userMapper.findByName("AAA");
		Assert.assertEquals(30, u.getAge().intValue());
		// 删除这条数据，并select验证
		userMapper.delete(u.getId());
		u = userMapper.findByName("AAA");
		Assert.assertEquals(null, u);
	}

	@Test
	@Rollback
	public void testUserMapper2() throws Exception {
		List<User> userList = userMapper.findAll();
		for(User user : userList) {
			Assert.assertEquals(null, user.getId());
			Assert.assertNotEquals(null, user.getName());
		}
	}
}
