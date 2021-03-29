package com.example.basic.algorithm.leecode.shuffle;

import java.util.Random;

/**
 * 打乱一个数组
 *
 * @author shaoxiangen
 * create in 2021/3/10
 */
public class Solution {


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        new Solution().run(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public void run(int[] a) {

        Random random = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, i, random.nextInt(i));
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
