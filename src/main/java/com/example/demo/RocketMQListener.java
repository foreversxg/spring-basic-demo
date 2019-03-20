package com.example.demo;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/11/20
 */
public interface RocketMQListener<T> {
    void onMessage(T message);
}
