package com.example.basic.design.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/19
 */
public class ProxyTest {

    public static void main(String[] args) {
        HouseBuyer james = new James();
        HouseBuyer houseBuyer = Proxy.getProxyClass(Thread.currentThread().getContextClassLoader(),new Class<?>[](HouseBuyer.class),james);
    }
}
