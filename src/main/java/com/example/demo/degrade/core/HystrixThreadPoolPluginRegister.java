package com.example.demo.degrade.core;

import com.netease.cloudmusic.hystrix.plugins.core.TraceHystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.HystrixPlugins;

/**
 *  hystrix插件注册组件
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/25
 */
public class HystrixThreadPoolPluginRegister {

    static {
        // 定制hystric线程池插件
        HystrixPlugins.getInstance().registerConcurrencyStrategy(new TraceHystrixConcurrencyStrategy());
    }
}
