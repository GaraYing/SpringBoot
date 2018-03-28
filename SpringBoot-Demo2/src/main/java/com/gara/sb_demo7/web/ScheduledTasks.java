package com.gara.sb_demo7.web;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * springBoot 实现定时任务
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat  = new SimpleDateFormat("HH:mm:ss");
    
    /**
     *  
     * 小哥哥加点注释呗~~
     * @author Gary
     * @date 2018/3/28 14:18
     * @param []
     * @return 
     *
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("当前时间："+dateFormat.format(new Date()));
    }
}
