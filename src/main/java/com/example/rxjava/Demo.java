package com.example.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/1/7
 */
public class Demo {

    public static void main(String[] args) {
        Observable observable =Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });
        observable.subscribe(new Observer1("jim"));

        observable.subscribe(new Observer1("tom"));
    }



    public static class Observer1 implements Observer<Integer>{

        private String name;

        public Observer1(String name) {
            this.name = name;
        }

        @Override
        public void onSubscribe(Disposable d) {
            System.out.println(name + ":subscribe");
        }

        @Override
        public void onNext(Integer value) {
            System.out.println(name + ":"+value);
        }

        @Override
        public void onError(Throwable e) {
            System.out.println(name + ":"+"error");
        }

        @Override
        public void onComplete() {
            System.out.println(name + ":"+"complete");
        }
    }
}
