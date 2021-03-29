package com.example.basic.algorithm.leecode.linkMerge;

import com.example.basic.algorithm.leecode.addTwoNum.Node;

/**
 * 两个有序链表合并成一个有序链表
 *
 * @author shaoxiangen
 * create in 2021/3/8
 */
public class Solution1 {


    /**
     * 递归解法
     *
     * @param n1
     * @param n2
     * @return
     */
    public Node mergeLinkNode(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        } else if (n2 == null) {
            return n1;
        }
        if (n1.getValue() <= n2.getValue()) {
            // n1大于n2,当前函数选择n1作为节点，下一个节点在n1.next和n2之间抉择
            n1.setNext(mergeLinkNode(n1.getNext(), n2));
            return n1;
        } else {
            n2.setNext(mergeLinkNode(n1, n2.getNext()));
            return n2;
        }
    }
}
