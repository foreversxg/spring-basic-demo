package com.example.demo.degrade.config;

import com.example.demo.degrade.core.HystrixThreadPoolPluginRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  hystrix插件导入注解
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/25
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(HystrixThreadPoolPluginRegister.class)
public @interface EnableHystrixtThreadPoolPlugin {
}
