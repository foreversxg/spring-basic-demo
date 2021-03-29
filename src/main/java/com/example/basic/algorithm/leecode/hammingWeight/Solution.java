package com.example.basic.algorithm.leecode.hammingWeight;

/**
 * 计算汉明重量
 * 计算数字二进制中1的个数
 *
 * @author shaoxiangen
 * create in 2021/3/4
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().run(3));
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
