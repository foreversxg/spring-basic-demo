package com.example.jdk;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/6
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> 1)
                .thenApply((a) -> {
                    System.out.println(a);//1
                    return a * 10;
                }).thenApply((a) -> {
                    System.out.println(a);//10
                    return a + 10;
                }).thenApply((a) -> {
                    System.out.println(a);//20
                    return a - 5;
                });
        System.out.println(future.get());//15
    }
}
