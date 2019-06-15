package com.example.jdk;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/10
 */
public class RetryTest {

    public static void main(String[] args) {
        new RetryTest().test();
    }
    public void test() {
        int count = 0;
        retry:
        for(;;) {
            count ++;
            if(count == 5)
                break retry;

        }
    }
}
