package com.springboot;

import com.springboot.service.UserService;
import com.springboot.service.WorkerRepository;
import com.springboot.vo.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*@EnableJpaRepositories(repositoryFactoryBeanClass=CustomRepositoryFactoryBean.class)*/
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

    @Autowired
    private WorkerRepository workerRepository;

    @Test
    public void test2() throws Exception {

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


}
