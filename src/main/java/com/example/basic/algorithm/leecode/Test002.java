package com.example.basic.algorithm.leecode;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * @Author shaoxiangen
 * @Date create in 2019/9/24
 */
public class Test002 {

    public static void main(String[] args) {
        int[]  a = new int[]{1,2,3,4,5};
        rotate(a,3);
        System.out.println(a);
    }

    public static void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        if (k > length) {
            k = k % length;
        }
        for (int i = 0; i< k;i ++) {
            int temp = nums[length - 1];
            for(int j = length-1;j >0;j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }

    }
}
