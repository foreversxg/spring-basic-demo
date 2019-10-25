package com.example.basic.algorithm.leecode;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 22，因为 nums[1] + nums[3] = 7 + 15 = 22，所以返回 [1, 3]
 * @Author shaoxiangen
 * @Date create in 2019/9/25
 */
public class Test004 {


    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{1,2,3,4,5,6,7},9));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int key = target - nums[i];
            if(map.get(key) != null) {
                System.out.println(i+","+map.get(key));
                return new int[]{i,map.get(key)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
