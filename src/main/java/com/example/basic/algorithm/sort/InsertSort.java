package com.example.basic.algorithm.sort;

import java.util.Arrays;

/**
 * 将数组分为左右两个子数组,将右边数组第一个元素插入到左边已排序数组对应的位置
 *
 * @author shaoxiangen
 * create in 2021/2/22
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {2, 6, 4, 3, 2, 7, 9, 8, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int k = i;
            for (int j = i - 1; j >= 0; j--) {
                if (value < array[j]) {
                    array[k] = array[j];
                    k = j;
                } else {
                    continue;
                }
            }
            if (value != array[k]) {
                array[k] = value;
            }

        }

    }
}
