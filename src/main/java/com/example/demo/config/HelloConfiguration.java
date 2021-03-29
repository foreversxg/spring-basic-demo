package com.example.demo.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

/**
 * @Author shaoxiangen
 * @Date create in 2019/8/19
 */
@Configuration
@Import({TestBean1.class})
public class HelloConfiguration {

    @Resource
    private ApplicationContext applicationContext;


    @Bean
    public TestBean2 testBean2() {
        TestBean1 testBean2 = applicationContext.getBean(TestBean1.class);
        return new TestBean2();
    }

    @Bean
    public TestBeanDefinitionRegistryPostProcessor testBeanDefinitionRegistryPostProcessor() {
        return new TestBeanDefinitionRegistryPostProcessor();
    }


}
