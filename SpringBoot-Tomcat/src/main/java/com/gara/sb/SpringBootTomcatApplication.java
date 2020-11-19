package com.gara.sb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

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
				.bannerMode(Banner.Mode.OFF)
				.web(WebApplicationType.SERVLET)
				.build()
				.run(args);
//		SpringApplication.run(SpringBootTomcatApplication.class, args);
	}

	/**
	 * {@link ApplicationRunner#run(ApplicationArguments)} 方法在SpringBoot应用启动之后回调
	 *
	 * @note 方法存在缺陷，未考虑非Web应用的场景（Reactive）
	 * @param context WebServerApplicationContext
	 * @return ApplicationRunner Bean
	 */
	@Bean
	public ApplicationRunner runner(WebServerApplicationContext context){

//		return new ApplicationRunner() {
//			@Override
//			public void run(ApplicationArguments args) throws Exception {
//				System.out.println("1. 当前webServer的实现类为： " + context.getWebServer().getClass().getName());
//			}
//		};

		return args -> {
			System.out.println("1. 当前webServer的实现类为： " + context.getWebServer().getClass().getName());
		};
	}

	@EventListener(WebServerInitializedEvent.class)
	public void onWebServerReady(WebServerInitializedEvent event){
		System.out.println("2. 当前webServer的实现类为： " + event.getWebServer().getClass().getName());
		System.out.println("当前webServer的启动端口为： " + event.getWebServer().getPort());
	}
}
