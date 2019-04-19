package com.example.basic.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/19
 */
public class MiddlePerson implements InvocationHandler {

    private HouseBuyer houseBuyer;

    public MiddlePerson(HouseBuyer houseBuyer) {
        this.houseBuyer = houseBuyer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("中介处理购房前手续");
        Object result = method.invoke(args);
        System.out.println("中介处理购房后手续");
        return result;
    }
}
