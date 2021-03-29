package com.example.basic.algorithm.leecode.findNoDuplicate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shaoxiangen
 * create in 2021/2/25
 */
public class Solution {


    public static void main(String[] args) {

        String s = "aadgeaard";
        System.out.println(new Solution().run(s));
    }

    public int run(String s) {
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                // 重复出现的位置和窗口左边的位置比较，如果重复的位置大，则向右移动窗口left
                left = Math.max(left, map.get(s.charAt(i)) + 1);
                max = Math.max(max, i - left + 1);
            }
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
