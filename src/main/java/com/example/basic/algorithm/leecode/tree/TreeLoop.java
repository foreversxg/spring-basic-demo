package com.example.basic.algorithm.leecode.tree;

import com.example.basic.algorithm.TreeNode;

/**
 * DLR--前序遍历（根在前，从左往右，一棵树的根永远在左子树前面，左子树又永远在右子树前面 ）
 * <p>
 * LDR--中序遍历（根在中，从左往右，一棵树的左子树永远在根前面，根永远在右子树前面）
 * <p>
 * LRD--后序遍历（根在后，从左往右，一棵树的左子树永远在右子树前面，右子树永远在根前面）
 *
 * @author shaoxiangen
 * create in 2021/4/14
 */
public class TreeLoop {

    public static void main(String[] args) {
        TreeNode root = TreeFactory.createTree();
        preOrder(root);
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    public static void middleOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.leftChild);
        System.out.println(root.data);
        preOrder(root.rightChild);
    }


    public static void endOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.leftChild);
        preOrder(root.rightChild);
        System.out.println(root.data);

    }
}
