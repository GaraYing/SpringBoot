package com.gara.sb_demo7;

import com.gara.sb_demo7.vo.Task;
import com.gara.sb_demo7.vo.User;
import com.gara.sb_demo7.vo.User2;
import com.gara.sb_demo7.vo.UserMapper;
import com.gara.sb_demo7.web.UserRepository;
import org.junit.Assert;
import org.junit.Before;
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
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SbDemo7ApplicationTests {


	@Before
	public void setUp() {
		userRepository.deleteAll();
	}


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

	@Autowired
	private UserRepository userRepository;


	@Test
	public void testMongoDb(){
		// 创建三个User，并验证User总数
		userRepository.save(new User2(1L, "didi", 30));
		userRepository.save(new User2(2L, "mama", 40));
		userRepository.save(new User2(3L, "kaka", 50));
		Assert.assertEquals(3, userRepository.findAll().size());

		// 删除一个User，再验证User总数
		User2 u = userRepository.findByUsername("didi");
		userRepository.delete(u);
		Assert.assertEquals(2, userRepository.findAll().size());

		// 删除一个User，再验证User总数
		u = userRepository.findByUsername("mama");
		userRepository.delete(u);
		Assert.assertEquals(1, userRepository.findAll().size());

	}

	@Test
	@Rollback
	public void testFlyway(){

	}

	@Autowired
	private Task task;

	@Test
	public void testTask() throws Exception{
		task.doTaskOne();
		task.doTaskTwo();
		task.doTaskThree();
	}

	@Test
	public void testTaskAsync() throws Exception{
		long start = System.currentTimeMillis();

		Future<String> task1 = task.doTaskOneAsync();
		Future<String> task2 = task.doTaskTwoAsync();
		Future<String> task3 = task.doTaskThreeAsync();

		while(true) {
			if(task1.isDone() && task2.isDone() && task3.isDone()) {
				// 三个任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();

		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
	}

}
