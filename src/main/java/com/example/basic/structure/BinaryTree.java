package com.example.basic.structure;

import com.example.basic.algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/10
 */
public class BinaryTree {

    //表示根节点
    public TreeNode root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(9);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(3);
        tree.add(4);
        tree.add(7);
        tree.add(0);
        System.out.println(tree);
        print(tree.root);
    }

    private static void print(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.data);
            if(current.leftChild != null) {
                queue.offer(current.leftChild);
            }
            if(current.rightChild != null) {
                queue.offer(current.rightChild);
            }

        }
    }


    public boolean add(int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return true;
        }
        TreeNode current = root;
        while (current != null) {
            TreeNode temp;
            if (current.data > data) {
                temp = current.leftChild;
                if(temp == null) {
                    current.leftChild = newNode;
                    return true;
                }
            } else if (current.data < data) {
                temp = current.rightChild;
                if(temp == null) {
                    current.rightChild = newNode;
                    return true;
                }
            } else {
                return false;
            }
            current = temp;
        }
        return false;
    }
}
