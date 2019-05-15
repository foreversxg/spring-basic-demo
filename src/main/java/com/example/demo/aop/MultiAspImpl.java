package com.example.demo.aop;

import org.springframework.stereotype.Component;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/15
 */
@Component
public class MultiAspImpl implements MultiAsp {
    @Override
    public void test() {
        System.out.println("This is a test for multi aspect!");
    }
}
