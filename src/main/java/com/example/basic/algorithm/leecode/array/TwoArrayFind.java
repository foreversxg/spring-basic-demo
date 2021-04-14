package com.example.basic.algorithm.leecode.array;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * <p>
 *
 * @author shaoxiangen
 * create in 2021/4/8
 */
public class TwoArrayFind {


    public static void main(String[] args) {
        int[][] a = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {18, 21, 23, 26, 30}};
        System.out.println(run(a, 12));

        System.out.println(run(a, 13));
        System.out.println(run(a, 23));

    }

    public static boolean run(int[][] a, int target) {
        if (a == null || a.length == 0 || a[0].length == 0) {
            return false;
        }
        int rows = a.length;
        int columns = a[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            int num = a[row][column];
            if (target == num) {
                return true;
            } else if (target < num) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }
}
