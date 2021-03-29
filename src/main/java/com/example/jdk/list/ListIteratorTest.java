package com.example.jdk.list;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.ListIterator;

/**
 * 好的接口设计可以提供方便的api，屏蔽内部实现细节
 *
 * @author shaoxiangen
 * create in 2021/3/11
 */
public class ListIteratorTest {


    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        test1(list);
        System.out.println(list);
    }

    /**
     * 反转集合
     *
     * @param list
     */
    public static void test1(List<Integer> list) {

        ListIterator start = list.listIterator();
        ListIterator end = list.listIterator(list.size());
        for (int i = 0, mid = list.size() >> 1; i < mid; i++) {
            Object tmp = start.next();
            start.set(end.previous());
            end.set(tmp);
        }
    }
}
