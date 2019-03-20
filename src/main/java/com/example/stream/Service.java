package com.example.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/6/5
 */
@Component
public class Service {

    @Autowired
    private Processor processor;

    public boolean write(String data) {
        return processor.output().send(MessageBuilder.withPayload(data).build());
    }

    public boolean subscribe(MessageHandler handler) {
        return processor.input().subscribe(handler);
    }
}
