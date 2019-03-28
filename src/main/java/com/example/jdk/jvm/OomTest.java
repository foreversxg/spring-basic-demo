package com.example.jdk.jvm;

import org.apache.commons.collections.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/28
 */
public class OomTest {

    public static void main(String[] args) {
        Map<String,String> map = new HashedMap(1024*10);
        int n = 0;
        while (true){
            n++;
            map.put(String.valueOf(n),new String(new byte[1024*1023]));
            System.out.println(n);
        }
    }
}
