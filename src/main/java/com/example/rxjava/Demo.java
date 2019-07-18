package com.example.rxjava;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/1/7
 */
public class Demo {

    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        //定义一个被观察者
        Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {

                Observable<String> mObservable = Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("事件订阅开始");
                    }
                });
                return mObservable;
            }
        }).doOnCompleted(new Action0() {
            @Override
            public void call() {
                System.out.println("success");
            }
        });
        Future future =  observable.toBlocking().toFuture();
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //订阅事件1，没产生一个订阅就会生成一个新的observable对象
        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                logger.info("观察者2订阅事件    "+s);
            }
        });
        //订阅事件2，没产生一个订阅就会生成一个新的observable对象
        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                logger.info("观察者1订阅事件    "+s);
            }
        });
    }
}
