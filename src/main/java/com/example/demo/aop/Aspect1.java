package com.example.demo.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/15
 */
@Aspect
@Order(3)
@Component
public class Aspect1 {

    @Pointcut("execution(* com.example.demo.aop.MultiAspImpl.test(..))")
    public void print(){

    }

    @Before("print()")
    public void before(){
        System.out.println("before 1 ....");
    }

    @After("print()")
    public void after(){
        System.out.println("after 1 ....");
    }

    @AfterReturning("print()")
    public void afterReturning(){
        System.out.println("afterReturning 1 ....");
    }

    @AfterThrowing("print()")
    public void afterThrowing(){
        System.out.println("afterThrowing 1 ....");
    }
}
