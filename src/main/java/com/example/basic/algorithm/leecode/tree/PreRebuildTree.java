package com.example.basic.algorithm.leecode.tree;

import com.example.basic.algorithm.TreeNode;

/**
 * 【前序、中序重建二叉树】
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
 * 中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并输出它的头结点。
 *
 * @author shaoxiangen
 * create in 2021/4/12
 */
public class PreRebuildTree {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3};
        int[] middle = {2, 1, 7, 4, 3};
        TreeNode node = new PreRebuildTree().run(pre, middle);
        System.out.println(node);
    }

    public TreeNode run(int[] pre, int[] middle) {
        TreeNode root = rebuild(pre, middle, 0, pre.length - 1, 0, middle.length - 1);
        return root;
    }

    private TreeNode rebuild(int[] pre, int[] middle, int preStart, int preEnd, int middleStart, int middleEnd) {
        if (preStart > preEnd || middleStart > middleEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = middleStart; i <= middleEnd; i++) {
            if (pre[preStart] == middle[i]) {
                root.leftChild = rebuild(pre, middle, preStart + 1, preStart + (i - middleStart), middleStart, i - 1);
                root.rightChild = rebuild(pre, middle, preStart + (i - middleStart) + 1, preEnd, i + 1, middleEnd);
            }
        }
        return root;
    }
}
