package com.example.basic.algorithm.leecode.tree;

import com.example.basic.algorithm.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * *2
 * 1  3
 * <p>
 * 输出：6
 * 解析：2—1—3为最大路径和
 * <p>
 * *-10
 * 9    20
 * ***15   7
 * <p>
 * 输出：42
 * 解析：15—20—7为最大路径和
 *
 * @author shaoxiangen
 * create in 2021/4/14
 */
public class TreeMax {

    static int currentMax = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.leftChild = new TreeNode(1);
        root.rightChild = new TreeNode(3);
        System.out.println(new TreeMax().onesideMax(root));
        System.out.println(currentMax);

    }

    public int onesideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, onesideMax(root.leftChild));
        int right = Math.max(0, onesideMax(root.rightChild));
        currentMax = Math.max(currentMax, left + right + root.data);
        return Math.max(left, right) + root.data;
    }
}
