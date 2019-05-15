package com.example.jdk.thread.pool.decorate;

import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程池支持threadlocal
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/15
 */
public class ThreadLocalSupportPoolTest {

    public static void main(String[] args) {

        new ThreadLocalSupportPoolTest().test_thread_pool();
    }

    public void test_general_pool() {
        ThreadConext.set("Hello word");
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(2);
        pool.setMaxPoolSize(5);
        pool.setKeepAliveSeconds(5);
        pool.setQueueCapacity(1000);
        pool.initialize();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(ThreadConext.get());
            }
        });
    }

    public void test_thread_pool() {
        ThreadConext.set("Hello word");
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(2);
        pool.setMaxPoolSize(5);
        pool.setKeepAliveSeconds(5);
        pool.setQueueCapacity(1000);
        pool.setTaskDecorator(new TaskDecorator() {
            @Override
            public Runnable decorate(Runnable runnable) {
                String temp =ThreadConext.get();
                return ()->{
                    ThreadConext.set(temp);
                    runnable.run();
                };
            }
        });
        pool.initialize();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                String str = ThreadConext.get();
                System.out.println(str);
            }
        });
        pool.shutdown();
    }

    public static class ThreadConext {

        private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

        public static void set(String str) {
            threadLocal.set(str);
        }

        public static String get(){
            return threadLocal.get();
        }
    }
}
