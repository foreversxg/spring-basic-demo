package com.example.demo.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/10/25
 */
@Component
public class MessageEventListener implements ApplicationListener {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof MessageEvent) {
            System.out.println(event.getSource());
        }
    }
}
