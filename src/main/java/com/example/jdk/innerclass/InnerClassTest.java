package com.example.jdk.innerclass;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

/**
 *  java匿名内部类讨论思考
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/14
 */
public class InnerClassTest {

    private List<String> globalList = new ArrayList<>();

    public static void main(String[] args) {
        new InnerClassTest().run_1();
    }

    private void run_1() {
        final List<String> list = new ArrayList<>();
        Runnable r = () -> {
            // 不可以修改list的
            // list = new ArrayList<>();
            System.out.println(list);
        };
        r.run();
    }

    private void run_2() {
        int num = 4;
        Runnable r = () -> {
            // 不可以修改num的
            // num = 5;
            System.out.println(num);
        };
        r.run();
    }

    private void run_3() {
        Runnable r = () -> {
            // 全局变量可以修改
            globalList = new ArrayList<>();
            System.out.println(globalList);
        };
        r.run();
    }


}
