package com.example.basic.algorithm.leecode;

/**
 * 实现斐波那契数列，输入n输出对应的值
 *
 * @author shaoxiangen
 * create in 2021/4/12
 */
public class FibonacciSequence {


    public static void main(String[] args) {
        System.out.println(new FibonacciSequence().func(2));
        System.out.println(new FibonacciSequence().func(5));

    }


    public int func(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return func(n - 1) + func(n - 2);
    }
}
