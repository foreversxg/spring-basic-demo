package com.example.basic.structure;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/10
 */
public class BinaryTree {

    //表示根节点
    public Node root;

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

    private static void print(Node root) {

        Queue<Node> queue = new ArrayDeque();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
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
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node current = root;
        while (current != null) {
            Node temp;
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


    public static class Node {

        int data;   //节点数据
        Node leftChild; //左子节点的引用
        Node rightChild; //右子节点的引用
        boolean isDelete;//表示节点是否被删除

        public Node(int data) {
            this.data = data;
        }
    }
}
