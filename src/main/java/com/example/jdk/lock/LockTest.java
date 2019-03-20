package com.example.jdk.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/7/31
 */
public class LockTest {
    public static void main(String[] args) {
        System.out.println("1");
        long now = System.currentTimeMillis();
        LockSupport.parkUntil(now + 1000*3);
        System.out.println("2");
    }
}
