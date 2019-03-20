package com.example.traffic;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/1/8
 */
public class JoinEntry extends Entry{

    private Entry next;

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }
}
