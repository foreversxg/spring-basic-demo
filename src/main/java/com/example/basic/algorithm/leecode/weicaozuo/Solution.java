package com.example.basic.algorithm.leecode.weicaozuo;

/**
 * 不用临时变量交换两个数
 *
 * @author shaoxiangen
 * create in 2021/3/4
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().run(4, 7);
    }

    public void run(int a, int b) {
        a ^= b;
        System.out.println(a);
        System.out.println(b);
        b ^= a;
        System.out.println(a);
        System.out.println(b);
        a ^= b;
        System.out.println(a);
        System.out.println(b);
    }
}
