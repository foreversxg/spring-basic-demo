package com.example.basic.algorithm.leecode.addTwoNum;

/**
 * @author shaoxiangen
 * create in 2021/2/24
 */
public class Solution {


    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.setNext(new Node(4));
        node1.getNext().setNext(new Node(3));

        Node node2 = new Node(5);
        node2.setNext(new Node(6));
        node2.getNext().setNext(new Node(4));

        new Solution().run(node1, node2);
    }

    /**
     * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字0之外，这两个数都不会以0开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public Node run(Node node1, Node node2) {
        Node outputNode = new Node();
        Node head1 = node1;
        Node head2 = node2;
        boolean hasPromotion = false;
        Node head3 = outputNode;
        while (head1 != null || head2 != null) {
            int a = head1 == null ? 0 : head1.getValue();
            int b = head2 == null ? 0 : head2.getValue();
            int sum = hasPromotion ? (a + b + 1) : (a + b);
            hasPromotion = (sum >= 10);
            if (head1 != null) {
                head1 = head1.getNext();
            }
            if (head2 != null) {
                head2 = head2.getNext();
            }
            head3.setNext(new Node(sum % 10));
            head3 = head3.getNext();
        }
        if (hasPromotion) {
            head3.setNext(new Node(1));
        }
        return outputNode.getNext();
    }
}
