package com.example.basic.design.proxy.cglib;

import com.example.basic.design.proxy.jdk.James;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CglibProxyTest2 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        James james = new James();
        James jamesProxy = (James)new CglibProxy().getInstance(james);
        Method[] methods = James.class.getDeclaredMethods();
        for(Method method:methods){
            if("setName".equals(method.getName())) {
                System.out.println(111);
                method.setAccessible(true);
                method.invoke(jamesProxy,"123");
            }
        }
        System.out.println(james.getName());
        System.out.println(jamesProxy.getName());
    }
}
