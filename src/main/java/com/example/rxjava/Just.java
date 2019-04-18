package com.example.rxjava;

import rx.Observable;
import rx.Subscriber;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/17
 */
public class Just {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Hello");
        Subscriber<String> subscriber = new Subscriber<String>() {
            //新增onStart方法，用来做一些初始化操作
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext");
            }
        };
        observable.subscribe(subscriber);
    }
}
