package com.example.basic.algorithm.sort;

import java.util.Random;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/8
 */
public class Test {

    public static void main(String[] args) {
        int size = 50;
        int[] a = new int[size];
        Random random = new Random();
        for(int i=0;i<size;i++) {
            a[i] = random.nextInt(size);
        }
//        int[] a = {2,5,3,8,6};
        long start = System.currentTimeMillis();
        sort(a,0,a.length-1);
        System.out.println("cost time:" + (System.currentTimeMillis() - start));
        for(int i:a){
            System.out.println(i);
        }
    }

    public static void sort(int[] a,int low,int high){
        if(low >= high) {
            return;
        }
        int index = test(a,low,high);
        sort(a,low,index-1);
        sort(a,index+1,high);
    }

    public static int test(int[] a,int low,int high){
        int key = a[low];
        while (low < high) {
            while (a[high] >= key && low < high) {
                high --;
            }
            a[low] = a[high];
            // >=  是因为存在相同的值，如果相同需要继续向前
            while (a[low] <= key && low < high) {
                low ++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }
}
