package com.example.jdk.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/9/3
 */
public class ReflectTest {

    public static void main(String[] args) throws IllegalAccessException {
        getDeclardMethod();
    }

    public static void processPriverFiled() throws IllegalAccessException {
        Demo demo = new Demo();
        demo.setName("abc");
        Field[] fields =  Demo.class.getDeclaredFields();
        Field field =  fields[0];
        field.setAccessible(true); // 设为true才能操作私有变量
        System.out.println(field.get(demo));
    }

    public static void getDeclardMethod() {
        Method[] methods = Demo.class.getDeclaredMethods();
        System.out.println(methods);
    }

}
