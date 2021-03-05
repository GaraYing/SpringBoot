package com.gara.sb.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnnotationTaskFinishEventListener {

    @EventListener
    @Async
    public void processTaskEvent(TaskFinishedEvent taskFinishedEvent){
        System.out.println("taskFinishedEvent is called " + taskFinishedEvent.getAddress());
    }


    @EventListener({TaskFinishedEvent.class, TaskStartedEvent.class})
    @Async
    public void processMultiTaskEvent(){
        System.out.println("taskFinishedEvent is called ********");
    }
}
