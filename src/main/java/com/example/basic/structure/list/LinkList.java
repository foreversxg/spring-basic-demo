package com.example.basic.structure.list;

public class LinkList<T> implements List<T>{


    private long size;
    private Node<T> first;
    private Node<T> last;

    @Override
    public void add(T t) {
        Node<T> newNode = new Node<T>(t);
        if(first == null) {
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size ++;
    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public long size() {
        return 0;
    }


    public static class Node<T>{
        T value;
        Node<T> next;

        Node (T v) {
            this.value = v;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}

