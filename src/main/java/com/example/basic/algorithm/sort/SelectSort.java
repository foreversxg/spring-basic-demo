package com.example.basic.algorithm.sort;

import java.util.Arrays;

/**
 * 将数组分为左右两个子数组，每一次从右边数组中选取一个最小的数放到左边数组的最后一位，最终完成从小到大的排序
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/4
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {2,6,4,3,7,9,8,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {

        for(int i=0;i<array.length;i++) {
            int k = i;
            for(int j = k;j<array.length;j++) {
                if(array[j] < array[k]) {
                    k = j;
                }
            }
            if(i != k) {
                int temp = array[k];
                array[k] = array[i];
                array[i] = temp;
            }
        }
    }
}
