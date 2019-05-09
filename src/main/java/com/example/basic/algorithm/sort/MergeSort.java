package com.example.basic.algorithm.sort;

/**
 * 归并
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/18
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {3,2,4,5,7,5,8,9,0};
        sort(a,0,a.length-1);
        for(int i:a) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a,int left,int right){
        int mid = (left + right) / 2;
        if(left < right) {
            sort(a,left,mid);
            sort(a,mid + 1,right);
            merge(a,left,mid,right);
        }
    }
    public static void merge(int[] a,int left,int mid,int right) {
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= right){
            if(a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {

                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=right){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+left] = temp[x];
        }
    }
}
