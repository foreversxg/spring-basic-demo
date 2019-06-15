package com.example.basic.design.proxy.chain;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/3
 */
public interface Filter {

    Object invoke(FilterChain chain);
}
