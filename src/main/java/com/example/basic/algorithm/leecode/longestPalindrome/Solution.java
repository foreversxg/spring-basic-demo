package com.example.basic.algorithm.leecode.longestPalindrome;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author shaoxiangen
 * create in 2021/3/1
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().run("bcabacd"));
    }


    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public String run(String s) {

        char[] charArray = s.toCharArray();
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > max && isPalindrome(charArray, i, j)) {
                    max = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, start + max);
    }

    private boolean isPalindrome(char[] charArray, int i, int j) {
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
