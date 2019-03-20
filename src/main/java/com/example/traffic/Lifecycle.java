package com.example.traffic;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/1/8
 */
public interface Lifecycle {

    void preStart();
    void execute();
    void end();
}
