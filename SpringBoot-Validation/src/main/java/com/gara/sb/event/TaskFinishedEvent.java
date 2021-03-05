package com.gara.sb.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class TaskFinishedEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */

    private final String address;
    private final String content;

    public TaskFinishedEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }
}
