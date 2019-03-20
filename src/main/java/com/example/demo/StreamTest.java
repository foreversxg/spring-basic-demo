package com.example.demo;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/10/16
 */
public class StreamTest {

    @Nullable
    private static String testFiled;

    public StreamTest() {
        this(null);
    }

    public StreamTest(@NonNull String testFiled){
        System.out.println(testFiled);
    }
    public static void main(String[] args) {
       new StreamTest();
    }
}
