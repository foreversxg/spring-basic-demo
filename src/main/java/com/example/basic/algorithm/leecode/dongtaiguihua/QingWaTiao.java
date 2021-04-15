package com.example.basic.algorithm.leecode.dongtaiguihua;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级的台阶总共有多少种跳法？
 *
 * @author shaoxiangen
 * create in 2021/4/15
 */
public class QingWaTiao {

    public static void main(String[] args) {
        System.out.println(jump2(7));
    }


    public static int jump(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return jump(n - 1) + jump(n - 2);
    }

    public static int jump2(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
