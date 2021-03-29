package com.example.basic.algorithm.leecode.threeSum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shaoxiangen
 * create in 2021/2/23
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new Solution().run(nums);
        System.out.println(result);
    }

    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     * <p>
     * Note:
     * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
     * The solution set must not contain duplicate triplets.
     * For example, given array S = {-1 0 1 2 -1 -4},
     * A solution set is:
     * (-1, 0, 1)
     * (-1, -1, 2)
     */
    public List<List<Integer>> run(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 这里用nums[i - 1] 很重要，不能用num(i+1)，会丢失部分结果
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int calc = nums[i] + nums[j] + nums[k];
                if (calc == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (calc < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;

    }
}
