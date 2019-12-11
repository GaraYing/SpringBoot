package com.gara.sb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author GARA
 */
@Slf4j
@SpringBootApplication
public class SpringBootTomcatApplication {

	@Bean
	public ServletContextListener contextListener(){
		return new ServletContextListener() {
			@Override
			public void contextInitialized(ServletContextEvent sce) {
				log.info("servletContext initialized...");
			}

			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				log.info("servletContext destroyed...");
			}
		};
	}

	public static void main(String[] args) {

		new SpringApplicationBuilder(SpringBootTomcatApplication.class)
				.bannerMode(Banner.Mode.CONSOLE)
				.web(WebApplicationType.SERVLET)
				.build()
				.run(args);
//		SpringApplication.run(SpringBootTomcatApplication.class, args);
	}

}
