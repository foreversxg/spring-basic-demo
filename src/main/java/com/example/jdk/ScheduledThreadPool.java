package com.example.jdk;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/17
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        Executor executor = new ScheduledThreadPoolExecutor(2);
        AtomicInteger count = new AtomicInteger(0);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello " + count.incrementAndGet());
            }
        };
        System.out.println("start");
        ((ScheduledThreadPoolExecutor) executor).scheduleAtFixedRate(r,5000,100,TimeUnit.MILLISECONDS);
    }
}
