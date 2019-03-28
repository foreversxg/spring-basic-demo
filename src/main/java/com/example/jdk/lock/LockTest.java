package com.example.jdk.lock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/7/31
 */
public class LockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        System.out.println("1");
        long now = System.currentTimeMillis();
        lock.lock();
        LockSupport.parkUntil(now + 1000*3);
        System.out.println("2");
    }
}
