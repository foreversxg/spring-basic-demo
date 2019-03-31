package com.example.basic.algorithm;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *
 * 示例:
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class LinkedList {

    public static void main(String[] args) {

        new LinkedList().exe();
    }

    public void exe() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.setNext(node2).setNext(node3).setNext(node4).setNext(node5).setNext(node6).setNext(node7);
        print(node1);
        removeNode(node5);
        print(node1);

    }

    public void print(Node node){
        Node tempNode = node;
        while (true) {
            System.out.print(tempNode.value + " ");
            if(tempNode.next == null) {
                break;
            }
            tempNode = tempNode.next;
        }
        System.out.println();
    }

//    public void removeNode(Node node) {
//        node = node.next;(不能修改引用的地址，修改了传入的地方引用依然用老的地址)
//
////        node.next = node.next.next;
//        System.out.println();
//    }
public void removeNode(Node node) {
    node.value = node.next.value;
    node.next = node.next.next;

//        node.next = node.next.next;
    System.out.println();
}

    static class Node {
        int value;
        Node next;

        public Node(int v) {
            this.value = v;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return next;
        }
    }
}
