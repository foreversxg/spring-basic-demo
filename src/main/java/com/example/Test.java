package com.example;

import org.apache.commons.collections.map.HashedMap;

import java.util.*;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/6/5
 */
public class Test {

    public static void main(String[] args) {
        Map<String,String> map = new Hashtable<>();
        map.put("1",null);
        System.out.println(map.get(null));
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.forEach(System.out::print);
//        System.out.println();
//        list.add(5,9);
//        list.forEach(System.out::print);
    }

    private static Long getVideoId(String url) {
        int beginIndex = url.indexOf("Id=") + 3;
        int endIndex = url.indexOf("&");
        return Long.valueOf(url.substring(beginIndex,endIndex));
    }
}
