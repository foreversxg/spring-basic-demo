package com.example.basic.design.proxy.cglib;

import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/28
 */
public class ProxyFactoryBeanTest {

    public static void main(String[] args) throws ClassNotFoundException {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setProxyInterfaces(new Class[]{UserBiz.class.getClass()});
        proxyFactoryBean.setInterceptorNames("logAdvice");
    }
}
