package com.example.jdk.loader;

import sun.applet.Main;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/23
 */
public class ClassForNameTest {

    public static void main(String[] args) throws ClassNotFoundException {
//        ClassLoader.getSystemClassLoader().loadClass("com.example.jdk.loader.TestPerson");
        Class.forName("com.example.jdk.loader.TestPerson");
//        System.out.println(TestPerson.getName());
    }
}


