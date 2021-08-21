package com.gara.sb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;

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
