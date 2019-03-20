package com.example.kafka;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.ResourceUtils;

import java.util.Properties;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/6/14
 */
public class KafkaProducer implements InitializingBean,DisposableBean {

    private Properties props;
    private  Producer<String, String> producer;

    public static void main(String[] args) throws Exception {
        KafkaProducer kafkaProducer = new KafkaProducer();
        kafkaProducer.afterPropertiesSet();
        kafkaProducer.send("test-1","测试一下");
        kafkaProducer.destroy();
    }


    public void send(String topic,String message) {
        producer.send(new ProducerRecord<String,String>(topic,message));

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(ResourceUtils.getURL("classpath:").getPath());
        props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
    }

    @Override
    public void destroy() throws Exception {
        producer.close();
    }
}
