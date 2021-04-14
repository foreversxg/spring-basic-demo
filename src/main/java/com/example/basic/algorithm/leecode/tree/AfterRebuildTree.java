package com.example.basic.algorithm.leecode.tree;

import com.example.basic.algorithm.TreeNode;

/**
 * 【后序、中序重建二叉树】
 * 思路：后序数组的最后一个元素就是根节点，前面的元素又分为左子树和右子树，结合中序数组可以得出左右子树的分界
 *
 * @author shaoxiangen
 * create in 2021/4/13
 */
public class AfterRebuildTree {

    public static void main(String[] args) {
        int[] middle = {4, 2, 3, 1, 5};
        int[] after = {4, 3, 5, 1, 2};
        TreeNode root = new AfterRebuildTree().run(middle, after);
        System.out.println(root);
    }

    public TreeNode run(int[] middle, int[] after) {


        return rebuildTree(middle, 0, middle.length - 1, after, 0, after.length - 1);
    }

    private TreeNode rebuildTree(int[] middle, int mStart, int mEnd, int[] after, int aStart, int aEnd) {

        if (mStart > mEnd || aStart > aEnd) {
            return null;
        }
        TreeNode root = new TreeNode(after[aEnd]);
        for (int i = mStart; i <= mEnd; i++) {
            if (middle[i] == after[aEnd]) {
                root.leftChild = rebuildTree(middle, mStart, i - 1, after, aStart, aStart + i - mStart - 1);
                root.rightChild = rebuildTree(middle, i + 1, mEnd, after, aStart + i - mStart, aEnd - 1);
            }
        }
        return root;
    }
}
