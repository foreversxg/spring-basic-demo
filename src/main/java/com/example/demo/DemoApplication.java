package com.example.demo;

import com.example.demo.degrade.config.EnableHystrixtThreadPoolPlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableHystrixtThreadPoolPlugin
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
