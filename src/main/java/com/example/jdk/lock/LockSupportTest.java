package com.example.jdk.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/7/31
 */
public class LockSupportTest {

    static class TestRunnable implements Runnable {
        Object u = new Object();
        @Override
        public void run() {
            synchronized (u) {
                System.out.println(Thread.currentThread().getName() + " 阻塞了！");
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + " 又可以high了！");
            }
        }
    }

    public static void main(String[] args) throws Exception{
        TestRunnable r = new TestRunnable();
        Thread thread1 = new Thread(r, "线程1");
        Thread thread2 = new Thread(r, "线程2");
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        LockSupport.unpark(thread1);
        LockSupport.unpark(thread2);
    }

}
