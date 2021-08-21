package com.gara.sb;

import com.gara.sb.event.EventPublisher;
import com.gara.sb.event.MailTaskEventPublisherAware;
import com.gara.sb.event.TaskFinishedEvent;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

public class SpringEventTest extends ValidationDemoApplicationTests {

    @Resource
    private EventPublisher eventPublisher;

    @Resource
    private MailTaskEventPublisherAware mailTaskEventPublisherAware;

    @Test
    public void testApplicationEvent(){
        eventPublisher.publishEvent(new TaskFinishedEvent("TaskStarted","123@qq.com","测试消息123"));
        eventPublisher.publishEvent(new TaskFinishedEvent("TaskFinished","456@qq.com","测试消息456"));
    }

    @Test
    public void testPublishEvent(){
        mailTaskEventPublisherAware.setBlockedList(Lists.newArrayList("2323@qq.com"));
        mailTaskEventPublisherAware.sendEmail("2323@qq.com", "测试消息发送2323");
    }
}
