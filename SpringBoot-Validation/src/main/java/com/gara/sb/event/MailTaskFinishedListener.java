package com.gara.sb.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 同步监听事件，publishEvent()被阻塞
 */
@Component
public class MailTaskFinishedListener implements ApplicationListener<TaskFinishedEvent> {

    @Override
    public void onApplicationEvent(TaskFinishedEvent event) {
        if (event.getSource() != null && event.getSource().equals("TaskFinished")){
            System.out.println("Send Email to " + event.getAddress() + " Task:" + event.getContent());
        }
    }
}
