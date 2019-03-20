package com.example.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/6/5
 */
@EnableBinding(value = { Processor.class })
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class);
        // 注册处理函数
        System.out.println("注册结果：" + setHander(context));
        // 发送消息
        System.out.println("发送结果：" + write(context));
    }

    // 发送消息
    public static boolean write(ConfigurableApplicationContext context) {
        Service service = context.getBean(Service.class);
        return service.write("狗子在吗?");
    }

    // 注册接收到消息时的处理函数
    public static boolean setHander(ConfigurableApplicationContext context) {
        Service service = context.getBean(Service.class);
        return service.subscribe(result -> {
            System.out.print("狗子收到消息：" + result.getPayload());
        });
    }
}