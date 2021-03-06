package com.example.basic.algorithm;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class TreeDeep {

    public int maxDepth(TreeNode root) {

        return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
