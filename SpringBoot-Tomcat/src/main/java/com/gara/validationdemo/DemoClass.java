package com.gara.validationdemo;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * @author GARA
 */
public class DemoClass {

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        try {
            tomcat.setPort(51111);
            // 表示tomcat启动的是一个webApplication
            tomcat.addWebapp("/mvc", "f:\\tomcat-docBase\\");
            tomcat.start();
            // 等待连接
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
