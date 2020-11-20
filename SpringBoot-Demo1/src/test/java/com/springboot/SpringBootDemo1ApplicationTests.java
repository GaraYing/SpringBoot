package com.springboot;

import com.springboot.service.UserService;
import com.springboot.service.WorkerRepository;
import com.springboot.vo.User2;
import com.springboot.vo.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/*@EnableJpaRepositories(repositoryFactoryBeanClass=CustomRepositoryFactoryBean.class)*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo1ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private UserService userService;

	@Before
	public void setUp() {
		// 准备，清空user表
		userService.deleteAllUsers();
	}

	@Test
	public void test() throws Exception {
		// 插入5个用户
		userService.create("a", 1);
		userService.create("b", 2);
		userService.create("c", 3);
		userService.create("d", 4);
		userService.create("e", 5);

		userService.updateUsers("e", 99);

		// 查数据库，应该有5个用户

		System.out.println("-=========***********=-===");
		Assert.assertEquals(5, userService.getAllUsers().intValue());
		System.out.println("-========***********-=-===");

		// 删除两个用户
		userService.deleteByName("a");
		userService.deleteByName("b");

//		userSerivce.deleteAllUsers();


		// 查数据库，应该有5个用户
		Assert.assertEquals(3, userService.getAllUsers().intValue());

	}

    @Autowired
    private WorkerRepository workerRepository;

    @Test
    public void test2() throws Exception {

//		workerRepository.deleteAll();
		workerRepository.deleteAllInBatch();

        // 创建10条记录
        workerRepository.save(new Worker("AAA", 10));
        workerRepository.save(new Worker("BBB", 20));
        workerRepository.save(new Worker("CCC", 30));
        workerRepository.save(new Worker("DDD", 40));
        workerRepository.save(new Worker("EEE", 50));
        workerRepository.save(new Worker("FFF", 60));
        workerRepository.save(new Worker("GGG", 70));
        workerRepository.save(new Worker("HHH", 80));
        workerRepository.save(new Worker("III", 90));
        workerRepository.save(new Worker("JJJ", 100));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(10, workerRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的Worker
        Assert.assertEquals(60, workerRepository.findByName("FFF").getAge().longValue());

        // 测试findUser, 查询姓名为FFF的Worker
        Assert.assertEquals(60, workerRepository.findWorker("FFF").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", workerRepository.findByNameAndAge("FFF", 60).getName());

        // 测试删除姓名为AAA的Worker
        workerRepository.delete(workerRepository.findByName("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, workerRepository.findAll().size());

    }

    @Autowired
	private StringRedisTemplate stringRedisTemplate;

    @Autowired
	private RedisTemplate redisTemplate;

    @Test
    public void testRedis(){
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

		// 保存对象
		User2 user = new User2("超人", 20);
		redisTemplate.opsForValue().set(user.getUserName(), user);

		user = new User2("蝙蝠侠", 30);
		redisTemplate.opsForValue().set(user.getUserName(), user);

		user = new User2("蜘蛛侠", 40);
		redisTemplate.opsForValue().set(user.getUserName(), user);

		Assert.assertEquals(20, ((User2)redisTemplate.opsForValue().get("超人")).getAge().longValue());
		Assert.assertEquals(30, ((User2)redisTemplate.opsForValue().get("蝙蝠侠")).getAge().longValue());
		Assert.assertEquals(40, ((User2)redisTemplate.opsForValue().get("蜘蛛侠")).getAge().longValue());

	}

//	@Autowired
//	private UserRepository userRepository;

//	@Test
//	public void testMongoDB(){
//
//			// 创建三个User，并验证User总数
//			userRepository.save(new User3(1L, "didi", 30));
//			userRepository.save(new User3(2L, "mama", 40));
//			userRepository.save(new User3(3L, "kaka", 50));
//			Assert.assertEquals(3, userRepository.findAll().size());
//
//			// 删除一个User，再验证User总数
//			User3 u = userRepository.findById(1L).get();
//			userRepository.delete(u);
//			Assert.assertEquals(2, userRepository.findAll().size());
//
//			// 删除一个User，再验证User总数
//			u = userRepository.findByUserName("mama");
//			userRepository.delete(u);
//			Assert.assertEquals(1, userRepository.findAll().size());
//	}

}
