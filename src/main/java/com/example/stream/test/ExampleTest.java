package com.example.stream.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/6/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExampleTest {

//    @Autowired
//    private Processor processor;
//
//    @Autowired
//    private MessageCollector messageCollector;
//
//    @Test
//    @SuppressWarnings("unchecked")
//    public void testWiring() {
//        Message<String> message = new GenericMessage<>("hello");
//        System.out.println(processor);
//        System.out.println(processor.input());
//        processor.input().send(message);
//        Message<String> received = (Message<String>) messageCollector.forChannel(processor.output()).poll();
//        System.out.println(received.getPayload());
//    }
//
////    @EnableBinding(Source.class)
////    public static class TimerSource {
////        @Bean
////        @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "${fixedDelay}", maxMessagesPerPoll = "1"))
////        public MessageSource<String> timerMessageSource() {
////            return () -> new GenericMessage<>("Hello world");
////        }
////    }
//
//    @SpringBootApplication
//    @EnableBinding(Processor.class)
//    public static class MyProcessor {
//
//        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//        @Autowired
//        private Processor processors;
//
//        @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
//        public String transform(String in) {
//            return in + " world";
//        }
//    }
}
