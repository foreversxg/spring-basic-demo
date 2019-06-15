package com.example.basic.design.proxy.cglib;

import com.example.basic.design.proxy.jdk.HouseBuyer;
import com.example.basic.design.proxy.jdk.James;
import com.example.basic.design.proxy.jdk.MiddlePerson;

import java.lang.reflect.Proxy;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/23
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        James james = new James();
        James jamesProxy = (James)new CglibProxy().getInstance(james);
        long count = 0;

        long time = System.currentTimeMillis();
        long num = 30;
        while (count++ < num) {
            jamesProxy.pay(1000);
        }
        System.out.println("cost:" + (System.currentTimeMillis() - time));
        HouseBuyer james2 = new James();
        MiddlePerson middlePerson = new MiddlePerson(james2);
        HouseBuyer houseBuyer = (HouseBuyer)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),james2.getClass().getInterfaces(),middlePerson);
        long time2 = System.currentTimeMillis();
        long count2 = 0;
        while (count2++ < num) {
            houseBuyer.pay(10000);
        }
        System.out.println("cost:" + (System.currentTimeMillis() - time2));

    }
}
