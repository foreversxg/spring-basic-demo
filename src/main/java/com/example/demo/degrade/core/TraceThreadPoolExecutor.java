package com.example.demo.degrade.core;

import com.example.demo.security.ThreadLocalTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  包装trace线程池实现
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/25
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {


    public TraceThreadPoolExecutor(int dynamicCoreSize, int dynamicCoreSize1, int keepAliveTime, TimeUnit minutes, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(dynamicCoreSize, dynamicCoreSize1, keepAliveTime, minutes, workQueue, threadFactory);
    }

    public void execute(Runnable command) {
        String value = ThreadLocalTest.get();
        super.execute(() -> {
            ThreadLocalTest.set(value);
            command.run();
        });
    }

}
