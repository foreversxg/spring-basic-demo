package com.example.demo.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/9
 */
@Configuration
public class WebFilterConfiguration {

    @Bean
    public WebFilter webFilter(){
        return new WebFilter();
    }
}
