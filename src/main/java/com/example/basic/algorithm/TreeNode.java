package com.example.basic.algorithm;

import com.example.basic.structure.BinaryTree;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/16
 */
public class TreeNode {

    public int data;   //节点数据
    public TreeNode leftChild; //左子节点的引用
    public TreeNode rightChild; //右子节点的引用
    public boolean isDelete;//表示节点是否被删除

    public TreeNode(int data) {
        this.data = data;
    }

}
