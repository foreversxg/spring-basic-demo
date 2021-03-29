package com.example.basic.algorithm.leecode.arrayDulplicateRemove;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author shaoxiangen
 * create in 2021/3/9
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 4, 5, 5, 6, 6, 6, 7};
        System.out.println(new Solution().run(a));
    }

    public int run(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return 1;
        }
        int i = 0;
        int j = i + 1;
        while (i < a.length && j < a.length) {
            if (a[i] == a[j]) {
                j++;
                continue;
            }
            i++;
            // 将不重复的数据移动到数组前列
            a[i] = a[j];
            j++;

        }
        System.out.println(a);
        return i + 1;
    }
}
