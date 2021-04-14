package com.example.basic.algorithm.leecode.statck;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 *
 * @author shaoxiangen
 * create in 2021/4/12
 */
public class StackAsQueue {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        appendTail(1);
        appendTail(2);
        System.out.println(deleteHead());
        appendTail(3);
        appendTail(4);
        System.out.println(deleteHead());
        appendTail(5);
        appendTail(6);
        System.out.println(deleteHead());
        System.out.println(deleteHead());
        System.out.println(deleteHead());

        System.out.println(deleteHead());
        System.out.println(deleteHead());
    }

    public static void appendTail(Integer num) {
        stack1.push(num);
    }


    public static int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.pop();
    }
}
