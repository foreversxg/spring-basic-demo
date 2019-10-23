package com.example.demo.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/10/17
 */
@Component
public class EnvironmentAwareTest implements EnvironmentAware,ApplicationContextAware {

    private ConfigurableEnvironment environment;
    private ApplicationContext applicationContext;
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment)environment;
        this.environment.getProperty("server.port");
        Map<String,Object> map = this.environment.getSystemProperties();
        MutablePropertySources mutablePropertySources= this.environment.getPropertySources();
//        System.out.println(map);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println(applicationContext);
    }
}
