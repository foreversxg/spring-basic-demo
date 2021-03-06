package com.example.jdk.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/10
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        new InterruptTest().test_block_synchronized();
    }

    private void test_interrupt_sleep() {
        Thread thread = new Thread(()->{

            try {
                System.out.println("sleep begin");
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
                System.out.println(Thread.interrupted());
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread interrupt");
        thread.interrupt();
    }

    private void test_interrupt_await() {
        Thread thread = new Thread(()->{

            try {
                System.out.println("wait begin");
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                System.out.println("wait interrupted");
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread interrupt");
        thread.interrupt();
    }

    private void test_block_synchronized() throws InterruptedException {
        SynchronizedBlocked sync = new SynchronizedBlocked();
        Thread t = new Thread(sync);
        // 启动后调用f()方法,无法获取当前实例锁处于等待状态
        t.start();
        TimeUnit.SECONDS.sleep(1);
        // 中断线程,无法生效
        t.interrupt();
    }

    public static class SynchronizedBlocked implements Runnable {

        public synchronized void f() {
            System.out.println("Trying to call f()");
            while (true) // Never releases lock
                Thread.yield();
        }

        /**
         * 在构造器中创建新线程并启动获取对象锁
         */
        public SynchronizedBlocked() {
            // 该线程已持有当前实例锁
            new Thread() {
                public void run() {
                    f(); // Lock acquired by this thread
                }
            }.start();
        }

        public void run() {
            // 中断判断
            while (true) {
                if (Thread.interrupted()) {
                    System.out.println("中断线程!!");
                    break;
                } else {
                    f();
                }
            }
        }
    }
}
