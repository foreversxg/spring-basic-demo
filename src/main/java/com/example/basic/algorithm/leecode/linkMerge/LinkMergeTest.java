package com.example.basic.algorithm.leecode.linkMerge;

import com.example.basic.algorithm.leecode.addTwoNum.Node;

/**
 * @author shaoxiangen
 * create in 2021/3/8
 */
public class LinkMergeTest {

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.setNext(new Node(4));
        node1.getNext().setNext(new Node(7));

        Node node2 = new Node(1);
        node2.setNext(new Node(5));
        node2.getNext().setNext(new Node(6));

        Node newNode = new Solution2().mergeLinkNode(node1, node2);
        while (newNode != null) {
            System.out.println(newNode.getValue());
            newNode = newNode.getNext();
        }
    }
}
