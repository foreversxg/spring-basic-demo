package com.example.demo.config;

import com.example.demo.HytrixConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author shaoxiangen
 * @Date create in 2019/8/19
 */
@Configuration
//@ConditionalOnMissingBean(HytrixConfiguration.class)
@ComponentScan("com.example.demo.config")
@Import(HelloRegister.class)
public class HelloConfiguration {
}
