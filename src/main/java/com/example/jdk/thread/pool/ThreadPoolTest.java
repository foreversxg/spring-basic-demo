package com.example.jdk.thread.pool;

import java.util.concurrent.*;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/11
 */
public class ThreadPoolTest {


    public static void main(String[] args) {
        new ThreadPoolTest().test_thread_pool_init();
    }

    private void test_pool_state() {
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(COUNT_BITS);
        int RUNNING    = -1 << COUNT_BITS;
        int SHUTDOWN   =  0 << COUNT_BITS;
        int STOP       =  1 << COUNT_BITS;
        int TIDYING    =  2 << COUNT_BITS;
        int TERMINATED =  3 << COUNT_BITS;
        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);

    }


    private void test_thread_pool_init() {
        ExecutorService executorService = new ThreadPoolExecutor(10,20,1000,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
        executorService.execute(()->{
            System.out.println("test");
        });
        executorService.shutdown();
    }

    private void test_shutdown_await() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            try {
                Thread.sleep(5000);
                System.out.println("thread exe finish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        System.out.println("pool close start");
        executorService.shutdown();
        System.out.println("pool close end");
        executorService.isShutdown();
    }
}
