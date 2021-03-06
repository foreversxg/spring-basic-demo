package com.example.basic.algorithm.leecode;

/**
 *
 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:

 输入: [2,2,1]
 输出: 1
 * @Author shaoxiangen
 * @Date create in 2019/9/24
 */
public class Test003 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,4,6,6};
        System.out.println(1 ^ 2);
        System.out.println(1 ^ 2 ^ 2);
        System.out.println(1 ^ 2 ^ 1);
        System.out.println(1 ^ 1);
        System.out.println(2 ^ 2);
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {

        if(nums == null) {
            return 0;
        }
        int result = 0;
        // 通过异或运算
        for(int i =0;i<nums.length ;i ++) {
            result ^=nums[i];
        }
        return result;
    }

}
