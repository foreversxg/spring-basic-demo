package com.example.basic.design.proxy.chain;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/3
 */
public class FilterDemo1 implements Filter {
    @Override
    public Object invoke(FilterChain chain) {
        return chain.proceed();
    }
}
