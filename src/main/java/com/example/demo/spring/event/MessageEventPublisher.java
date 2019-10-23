package com.example.demo.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/10/25
 */
@Component
public class MessageEventPublisher implements ApplicationEventPublisherAware,ApplicationListener<ContextRefreshedEvent> {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        applicationEventPublisher.publishEvent(new MessageEvent("Hello"));
    }
}
