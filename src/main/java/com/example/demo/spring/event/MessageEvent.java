package com.example.demo.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/10/25
 */
public class MessageEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MessageEvent(Object source) {
        super(source);
    }
}
