package com.gara.sb;

import com.gara.sb.controller.UserControllerInterceptor;
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
	public void  addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserControllerInterceptor());
	}
}
