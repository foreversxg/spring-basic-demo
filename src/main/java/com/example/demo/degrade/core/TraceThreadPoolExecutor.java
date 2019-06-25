package com.example.demo.degrade.core;

import com.netease.cloudmusic.trace.client.TraceInfo;
import com.netease.cloudmusic.trace.client.Tracer;

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
        TraceInfo traceInfo =Tracer.getCurrentTraceInfo();
        super.execute(() -> {
            Tracer.setCurrentTraceInfo(traceInfo);
            command.run();
        });
    }

}
