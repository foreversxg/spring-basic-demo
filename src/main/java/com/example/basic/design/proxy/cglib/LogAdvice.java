package com.example.basic.design.proxy.cglib;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/28
 */
public class LogAdvice implements MethodBeforeAdvice {

    private Logger logger=Logger.getLogger(LogAdvice.class);
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        //获取被调用的类名
        String targetClassname=target.getClass().getName();
        //获取被调用的方法名
        String targetMethodname=method.getName();
        String logInfoText="前置通知："+targetClassname+"类的"+targetMethodname+"方法开始执行";
        logger.info(logInfoText);
    }
}
