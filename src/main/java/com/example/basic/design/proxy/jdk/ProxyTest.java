package com.example.basic.design.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/19
 */
public class ProxyTest {

    public static void main(String[] args) {
        HouseBuyer james = new James();
        MiddlePerson middlePerson = new MiddlePerson(james);
        HouseBuyer houseBuyer = (HouseBuyer)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),james.getClass().getInterfaces(),middlePerson);
        houseBuyer.pay(10000);
    }
}
