package com.example.basic.algorithm;

import com.example.basic.structure.BinaryTree;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/16
 */
public class ReverseTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(5);
        binaryTree.add(4);
        binaryTree.add(3);
        binaryTree.add(6);
//        new ReverseTree().reverse(binaryTree.root);
        new ReverseTree().afterPint(binaryTree.root);

    }

    // 前序
    public void beforePrint(TreeNode root){
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        beforePrint(root.leftChild);
        beforePrint(root.rightChild);
    }
    // 中序
    public void midPint(TreeNode root){
        if(root == null) {
            return;
        }
        midPint(root.leftChild);
        System.out.println(root.data);
        midPint(root.rightChild);
    }

    // 中序
    public void afterPint(TreeNode root){
        if(root == null) {
            return;
        }
        afterPint(root.leftChild);
        afterPint(root.rightChild);
        System.out.println(root.data);
    }

    public void reverse(TreeNode root){

        if(root.rightChild != null ) {
            reverse(root.rightChild);
        }
        if( root.leftChild != null) {
            reverse(root.leftChild);
        }
        swap(root);
    }

    private void swap(TreeNode root) {
        TreeNode treeNode = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = treeNode;
    }
}
