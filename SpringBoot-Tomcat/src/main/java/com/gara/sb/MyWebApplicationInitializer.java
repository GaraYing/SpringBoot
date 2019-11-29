package com.gara.sb;

import com.gara.sb.service.CustomerService;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author GARA
 */
@EnableWebMvc
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        System.out.println("Spring init start+++++++++++++++");

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        context.register(CustomerService.class);

        context.refresh();
        System.out.println("Spring init end+++++++++++++++");

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("mvc", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("*.do");

    }
}
