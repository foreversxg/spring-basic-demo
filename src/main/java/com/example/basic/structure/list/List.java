package com.example.basic.structure.list;

public interface List<T> {

    void add(T t);

    boolean delete(T t);

    T get(int index);

    long size();
}
