package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.Arrays;
import java.util.Properties;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/6/14
 */
public class KafkaConsumerListener implements InitializingBean,DisposableBean {

    private Properties props;
    private KafkaConsumer<String, String> consumer;

    public static void main(String[] args) throws Exception {
        KafkaConsumerListener kafkaConsumerListener = new KafkaConsumerListener();
        kafkaConsumerListener.afterPropertiesSet();
        kafkaConsumerListener.onMessage();
        kafkaConsumerListener.destroy();
    }

    public void onMessage() {
        consumer.subscribe(Arrays.asList("test-2"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                consumer.commitSync();
            }
        }
    }
    @Override
    public void destroy() throws Exception {
        consumer.close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<>(props);
    }
}
