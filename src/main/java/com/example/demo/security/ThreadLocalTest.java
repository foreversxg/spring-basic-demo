package com.example.demo.security;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/25
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void set(String v) {
        threadLocal.set(v);
    }

    public static String get() {
        return threadLocal.get();
    }
}
