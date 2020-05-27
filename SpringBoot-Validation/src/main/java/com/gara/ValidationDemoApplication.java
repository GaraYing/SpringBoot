package com.gara;

import com.gara.sb.controller.UserControllerInterceptor;
import com.gara.sb.property.SampleProperties;
import com.gara.sb.validation.SamplePropertiesValidator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ValidationDemoApplication implements WebMvcConfigurer, CommandLineRunner {

	private final SampleProperties properties;

	public ValidationDemoApplication(SampleProperties properties) {
		this.properties = properties;
	}

//	@Bean
//	public static Validator configurationPropertiesValidator() {
//		return new SamplePropertiesValidator();
//	}

	@Override
	public void  addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserControllerInterceptor());
	}



	@Override
	public void run(String... args) throws Exception {
		System.out.println("=========================================");
		System.out.println("Sample host: " + this.properties.getHost());
		System.out.println("Sample port: " + this.properties.getPort());
		System.out.println("=========================================");
	}

	public static void main(String[] args) {
		SpringApplication.run(ValidationDemoApplication.class, args);
	}
}
