package com.example.jdk.thread.pool;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/10
 */
public class InterruptTest2 {

    public static void main(String[] args) {
        test_2();
    }

    /**
     *     public static boolean interrupted() {
     *         return currentThread().isInterrupted(true);
     *     }
     */
    private static void test_1() {
        System.out.println(Thread.interrupted());
        Thread.currentThread().interrupt();
        // static  interrupted 判断完后会将中断标志置为false
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
    }

    /**
     * public boolean isInterrupted() {
     *         return isInterrupted(false);
     *     }
     */
    private static void test_2() {
        System.out.println(Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        // Thread.currentThread().isInterrupted()不会修改中断标志置
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().isInterrupted());
    }
}
