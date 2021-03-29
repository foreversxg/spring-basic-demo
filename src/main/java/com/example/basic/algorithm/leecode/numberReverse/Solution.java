package com.example.basic.algorithm.leecode.numberReverse;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 *
 * @author shaoxiangen
 * create in 2021/3/1
 */
public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().run(-234235));
    }

    public int run(Integer num) {

        int res = 0;
        while (num != 0) {
            int temp = num % 10;
            res = res * 10 + temp;
            // TODO 条件check
            num = num / 10;
        }
        return res;
    }
}
