package com.example.basic.algorithm.leecode.weicaozuo;

/**
 * 计算汉明重量
 * 计算数字二进制中1的个数
 *
 * @author shaoxiangen
 * create in 2021/3/4
 */
public class Solution02 {

    public static void main(String[] args) {
        System.out.println(new Solution02().run(3));
    }

    public int run(int num) {

        int size = 0;
        while (num != 0) {
            num = num & (num - 1);
            size++;
        }
        return size;
    }
}
