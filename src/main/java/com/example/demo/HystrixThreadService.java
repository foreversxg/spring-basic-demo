package com.example.demo;

import com.example.demo.security.ThreadLocalTest;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/18
 */
@Service
public class HystrixThreadService {


    @HystrixCommand(
            groupKey = "timeline-group-rcmd",
            fallbackMethod = "callback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"), // 信号量隔离，因为业务方法用了ThreadLocal
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100"), //超时时间
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "50"),//触发熔断最小请求数量
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30"),//触发熔断的错误占比阈值
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000"),//熔断器回复时间
                    @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "300"),// 单机最高并发
                    @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "100")// fallback单机最高并发
            }
    )
    public String call1() {
        System.out.println(ThreadLocalTest.get());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println("main work:" + System.currentTimeMillis());
        return "main";

    }
    /**
     * @return
     */
    @HystrixCommand(
            groupKey = "thread-timeline-main-rcmd",
            fallbackMethod = "fallback" ,
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.strategy", value="THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"), //超时时间
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value="20"),//触发熔断最小请求数量
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="50"),//触发熔断的错误占比阈值
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value="5000"),//熔断器回复时间
                        @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value="300")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "123"), //核心线程数，当前版本不支持显示设置最大线程数，最大线程数=核心线程数
                    @HystrixProperty(name = "maxQueueSize", value = "1000"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "50"),
            }
    )
    public String call2(){
        try {
            System.out.println("线程池：" + ThreadLocalTest.get());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("main work:" + System.currentTimeMillis());
        return "main";
    }

    public String fallback() {
        System.out.println("callback：" + System.currentTimeMillis());
        return "fallback";
    }
}
