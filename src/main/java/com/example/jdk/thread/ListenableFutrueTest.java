package com.example.jdk.thread;

import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SettableListenableFuture;

import java.util.concurrent.*;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/9
 */
public class ListenableFutrueTest {



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future =service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000*5);
//                int i = 5/0;
                return "Hello";
            }
        });
//        String result = future.get();
        SettableListenableFuture listenableFuture = new SettableListenableFuture();
        listenableFuture.addCallback(new ListenableFutureCallback(){

            @Override
            public void onSuccess(Object result) {
                System.out.println("i get the result:" + result);
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("execute error:" + ex.getMessage());
            }
        });
        service.execute(() -> {
            try {
                String result =  future.get();
                listenableFuture.set(result);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            } catch (ExecutionException e) {
                listenableFuture.setException(e);
//                e.printStackTrace();
            }
        });
        try {
            listenableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdownNow();


    }
}
