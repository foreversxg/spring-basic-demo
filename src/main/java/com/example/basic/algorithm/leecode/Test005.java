package com.example.basic.algorithm.leecode;

import com.example.basic.structure.list.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @Author shaoxiangen
 * @Date create in 2019/9/28
 */
public class Test005 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNum_1(l1,l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNum_1(ListNode l1,ListNode l2){

        if(l1 == null || l2 == null) {
            return l1 == null ? l1:l2;
        }
        int value = l1.val + l2.val;
        ListNode newListNode = new ListNode(value % 10);
        newListNode.next = addTwoNum_1(l1.next,l2.next);
        if(value >= 10) {
            newListNode.next = addTwoNum_1(new ListNode(value/10),newListNode.next);
        }

        return newListNode;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
