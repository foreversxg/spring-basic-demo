package com.example.demo.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author shaoxiangen
 * @Date create in 2019/8/19
 */
public class HelloRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        importingClassMetadata.getAnnotationTypes();
        System.out.println("hello");
    }
}
