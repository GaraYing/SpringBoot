package com.gara.sb;

import com.gara.sb.controller.CustomerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationDemoApplicationTests {

	@Test
	public void contextLoads() {
	}


	public static void main(String[] args) {
		long currentTimeMillis = System.currentTimeMillis();
		String s = CompletableFuture.supplyAsync(ValidationDemoApplicationTests::hello)
				.thenCombine(
						CompletableFuture.supplyAsync(
								ValidationDemoApplicationTests::world), (s1, s2) -> s1 + " " + s2).join();
		System.out.println(s);
		System.out.println(System.currentTimeMillis() - currentTimeMillis + "ms");
	}

	private static String hello(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello";
	}

	private static String world(){
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "world";
	}
}
