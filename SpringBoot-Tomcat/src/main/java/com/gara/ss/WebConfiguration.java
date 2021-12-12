package com.gara.ss;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @author GARA
 * @version V1.0.0
 * @description
 * @date 2020/11/30 21:49
 **/
@Configuration
public class WebConfiguration {

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event){
        System.out.println("当前webServer的实现类为： " + event.getWebServer().getClass().getName());
        System.out.println("当前webServer的启动端口为： " + event.getWebServer().getPort());
    }
}
