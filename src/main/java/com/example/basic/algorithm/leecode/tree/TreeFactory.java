package com.example.basic.algorithm.leecode.tree;

import com.example.basic.algorithm.TreeNode;

/**
 * @author shaoxiangen
 * create in 2021/4/14
 */
public class TreeFactory {

    public static TreeNode createTree() {
        /*
                          2
                      1      3
                    4   6       5
         */
        TreeNode root = new TreeNode(2);
        root.leftChild = new TreeNode(1);
        root.rightChild = new TreeNode(3);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(6);

        root.rightChild.rightChild = new TreeNode(5);
        return root;
    }
}
