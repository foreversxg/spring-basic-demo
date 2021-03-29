package com.example.basic.algorithm.leecode.linkMerge;

import com.example.basic.algorithm.leecode.addTwoNum.Node;

/**
 * 两个有序链表合并成一个有序链表
 *
 * @author shaoxiangen
 * create in 2021/3/8
 */
public class Solution2 {

    /**
     * 非递归解法
     */
    public Node mergeLinkNode(Node n1, Node n2) {

        Node target = new Node();
        Node newNode;
        newNode = target;
        while (n1 != null || n2 != null) {
            if (n1 == null) {
                target.setValue(n2.getValue());
                target.setNext(n2.getNext());
                break;
            }
            if (n2 == null) {
                target.setValue(n1.getValue());
                target.setNext(n1.getNext());
                break;
            }
            if (n1.getValue() <= n2.getValue()) {
                target.setValue(n1.getValue());
                target.setNext(new Node());
                target = target.getNext();
                n1 = n1.getNext();
            } else {
                target.setValue(n2.getValue());
                target.setNext(new Node());
                target = target.getNext();
                n2 = n2.getNext();
            }

        }
        return newNode;
    }
}
