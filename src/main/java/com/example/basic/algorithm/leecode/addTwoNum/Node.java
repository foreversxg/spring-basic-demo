package com.example.basic.algorithm.leecode.addTwoNum;

/**
 * @author shaoxiangen
 * create in 2021/2/24
 */
public class Node {

    private int value;
    private Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
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

    public void setNext(Node next) {
        this.next = next;
    }
}
