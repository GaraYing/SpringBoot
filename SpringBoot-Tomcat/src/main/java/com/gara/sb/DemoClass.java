package com.gara.sb;

import com.gara.sb.controller.CustomerController;
import com.gara.sb.service.CustomerService;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author GARA
 */
public class DemoClass {

    /**
     * The class name of default protocol used.
     */
    public static final String DEFAULT_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol";

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        try {
            tomcat.setPort(51111);
            // 表示tomcat启动的是一个webApplication
            tomcat.addContext("/", "f:\\tomcat-docBase\\");
//            tomcat.start();
////             等待连接
//            tomcat.getServer().await();
            Connector connector = new Connector(DEFAULT_PROTOCOL);
            connector.setPort(52222);
            tomcat.getService().addConnector(connector);
            tomcat.setConnector(connector);


            TomcatWebServer tomcatWebServer = new TomcatWebServer(tomcat, true);
            tomcatWebServer.start();

            System.out.println("Spring init start+++++++++++++++");

            AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

            context.register(CustomerService.class);
            context.register(CustomerController.class);

            context.refresh();
            System.out.println("Spring init end+++++++++++++++");

            // Create and register the DispatcherServlet
            DispatcherServlet servlet = new DispatcherServlet(context);

            Wrapper mvc = tomcat.addServlet("/", "mvc", servlet);

//            ServletRegistration.Dynamic registration = servletContext.addServlet("mvc", servlet);
            mvc.setLoadOnStartup(1);
            mvc.addMapping("*.do");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
