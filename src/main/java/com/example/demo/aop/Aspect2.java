package com.example.demo.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/15
 */
@Aspect
@Order(2)
@Component
public class Aspect2 {

    @Pointcut("execution(* com.example.demo.aop.MultiAspImpl.test(..))")
    public void print(){

    }

    @Before("print()")
    public void before(){
        System.out.println("before 2 ....");
    }

    @After("print()")
    public void after(){
        System.out.println("after 2 ....");
    }

    @AfterReturning("print()")
    public void afterReturning(){
        System.out.println("afterReturning 2 ....");
    }

    @AfterThrowing("print()")
    public void afterThrowing(){
        System.out.println("afterThrowing 2 ....");
    }
}
