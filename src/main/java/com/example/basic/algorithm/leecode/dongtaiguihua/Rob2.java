package com.example.basic.algorithm.leecode.dongtaiguihua;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * @author shaoxiangen
 * create in 2021/4/15
 */
public class Rob2 {


    public static void main(String[] args) {
        int[] nums = {6, 2, 3, 1, 7};
        System.out.println(run(nums));
    }


    public static int run(int[] nums) {

        int length = nums.length;

        // 抢第一家
        int[] res1 = new int[length];
        res1[0] = nums[0];
        res1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length - 1; i++) {

            res1[i] = Math.max(res1[i - 2] + nums[i], res1[i - 1]);
        }
        // 不抢第一家
        int[] res2 = new int[length];
        res2[1] = nums[1];
        res2[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i <= length - 1; i++) {
            res2[i] = Math.max(res2[i - 2] + nums[i], res2[i - 1]);

        }
        return Math.max(res1[length - 2], res2[length - 1]);
    }
}
