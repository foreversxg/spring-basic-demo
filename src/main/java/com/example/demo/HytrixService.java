package com.example.demo;

import com.example.demo.security.ThreadLocalTest;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/12/21
 */
@Service
public class HytrixService {



    @HystrixCommand(
            groupKey = "timeline-group-rcmd",
            fallbackMethod = "failback",
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
    public String call() {
        System.out.println("main run start:" + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("thead interruptedException");

        }
        System.out.println("main run end:" + System.currentTimeMillis()+"threadName:" + Thread.currentThread().getName());
        return "main return";

    }

    public String failback() {
        System.out.println("failback run：" + System.currentTimeMillis()+"threadName:" + Thread.currentThread().getName());
        return "failback return";
    }

//    @HystrixCommand(
//            groupKey = "timeline-group-rcmd-2",
//            fallbackMethod = "callback",
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"), // 信号量隔离，因为业务方法用了ThreadLocal
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100"), //超时时间
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "50"),//触发熔断最小请求数量
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30"),//触发熔断的错误占比阈值
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000"),//熔断器回复时间
//                    @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "300"),// 单机最高并发
//                    @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "100")// fallback单机最高并发
//            }
//    )
//    public String call2() {
//        count++;
//        System.out.println(ThreadLocalTest.get());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//        }
//        System.out.println("main work:" + System.currentTimeMillis());
//        return "main";
//
//    }
//
//    @HystrixCommand(
//            groupKey = "timeline-group-rcmd-3",
//            fallbackMethod = "callback2",
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"), // 信号量隔离，因为业务方法用了ThreadLocal
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100"), //超时时间
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "50"),//触发熔断最小请求数量
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30"),//触发熔断的错误占比阈值
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000"),//熔断器回复时间
//                    @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "300"),// 单机最高并发
//                    @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "100")// fallback单机最高并发
//            }
//    )
//    public String callback()  {
//        System.out.println("callback：" + System.currentTimeMillis());
//        try {
//            Thread.currentThread().sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "callback";
//    }

}
