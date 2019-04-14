package com.example.basic.algorithm.sort;

import java.util.Random;

/**
 * 时间复杂度：最优->O(NlogN). 最差 ->O(n^2)
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/3
 */
public class QuickSort {

    public static void main(String[] args) {
        int size = 50;
        int[] a = new int[size];
        Random random = new Random();
        for(int i=0;i<size;i++) {
            a[i] = random.nextInt(size);
        }
        long start = System.currentTimeMillis();
        sort(a,0,a.length-1);
        System.out.println("cost time:" + (System.currentTimeMillis() - start));
        for(int i:a){
            System.out.println(i);
        }
    }

    private static void sort(int[] a,int low,int high) {
        // 递归终止条件
        if(low >= high) {
            return;
        }
        int index = sortDetail(a,low,high);
        sort(a,low,index-1);
        sort(a,index + 1,high);
    }

    private static int sortDetail(int[] a,int low,int high) {
        int key = a[low];
        while (high > low) {
            // >=  是因为存在相同的值，如果相同需要继续向后
            while(a[high] >= key && high > low) {
                high --;
            }
            a[low] = a[high];
            // <=  是因为存在相同的值，如果相同需要继续向前
            while (a[low] <= key && high > low) {
                low ++;
            }
            a[high] = a[low];
        }
        // 此时 low == high
        a[low] = key;
        return high;
    }
}
