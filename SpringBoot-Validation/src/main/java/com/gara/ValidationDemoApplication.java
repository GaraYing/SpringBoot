package com.gara;

import com.gara.sb.controller.UserControllerInterceptor;
import com.gara.sb.property.SampleProperties;
import com.gara.sb.validation.SamplePropertiesValidator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

//@SpringBootApplication
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
//		SpringApplication.run(ValidationDemoApplication.class, args);

		Set<String> sources = new HashSet<>();
		sources.add(ApplicationConfiguration.class.getName());

		SpringApplication.run(ApplicationConfiguration.class, args);
		SpringApplication springApplication = new SpringApplication();
		springApplication.setSources(sources);
		springApplication.setWebApplicationType(WebApplicationType.NONE);

		ConfigurableApplicationContext context = springApplication.run();
		System.out.println("ValidationDemoApplication.main: " + context.getBean(ApplicationConfiguration.class));
	}

	@SpringBootApplication
	public static class ApplicationConfiguration{

	}
}
