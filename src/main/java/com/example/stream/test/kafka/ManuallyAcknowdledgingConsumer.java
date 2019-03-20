package com.example.stream.test.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/6/19
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class ManuallyAcknowdledgingConsumer {

    public static void main(String[] args) {
        ManuallyAcknowdledgingConsumer manuallyAcknowdledgingConsumer = new ManuallyAcknowdledgingConsumer();
        SpringApplication.run(ManuallyAcknowdledgingConsumer.class, args);
        System.out.println("hello");
    }


    @StreamListener(Sink.INPUT)
    public void process(Message<?> message) {
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            System.out.println("Acknowledgment provided");
            acknowledgment.acknowledge();
        }
    }
}
