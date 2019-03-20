package com.example.demo;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/12/21
 */
@Configuration
public class HytrixConfiguration {

    @Bean
    public HystrixCommandAspect hystrixCommandAspect(){
        return new HystrixCommandAspect();
    }
}
