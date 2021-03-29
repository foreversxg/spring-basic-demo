package com.example.jdk.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/28
 */
public class OomTest {

    public static void main(String[] args) {
        PigMachine pigMachine = new PigMachine();
        ExecutorService pool = Executors.newFixedThreadPool(1);
        while (true) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("pig eat：");
                    try {
                        pigMachine.eat();
                    } catch (Throwable e) {
                        e.printStackTrace();
                        System.out.println("我裂开了！！！");
                    }
                }
            });
        }
    }
}
