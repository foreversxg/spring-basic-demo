package com.example.basic.algorithm.leecode.findNoDuplicate;

import java.util.HashMap;
import java.util.Map;

/**
 *查找出一个字符串不重复字符的最大长度
 *
 * @author shaoxiangen
 * create in 2021/2/25
 */
public class Solution {


    public static void main(String[] args) {

        String s = "abcdefg";
        System.out.println(new Solution().run(s));
    }

    public int run(String str) {
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            Character ch = str.charAt(i);
            if (map.containsKey(ch)) {
                // 重复出现的位置和窗口左边的位置比较，如果重复的位置大，则向右移动窗口left
                left = Math.max(left, i + 1);
                max = Math.max(max, i - left + 1);

            }
            map.put(str.charAt(i), i);
        }
        max = Math.max(max, length - left + 1);
        return max;
    }
}
