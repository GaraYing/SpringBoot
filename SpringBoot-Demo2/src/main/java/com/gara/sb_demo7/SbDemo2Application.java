package com.gara.sb_demo7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling	// 定时任务
@EnableAsync // 异步调用
@SpringBootApplication
public class SbDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SbDemo2Application.class, args);
	}
}