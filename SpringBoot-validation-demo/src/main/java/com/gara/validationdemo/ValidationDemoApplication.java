package com.gara.validationdemo;

import com.gara.validationdemo.controller.UserControllerInterceptor;
import com.gara.validationdemo.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ValidationDemoApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ValidationDemoApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserControllerInterceptor());
	}
}
