package com.example.basic.structure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/15
 */
public class SimpleLRUCache {

    private LinkedHashMap<String,String> cache;

    public SimpleLRUCache(int size) {
        cache = new LinkedHashMap<String,String>(size,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String,String> eldest) {
                boolean tooBig = size() > size;
                if(tooBig) {
                    System.out.println("最近最少使用key="+eldest.getKey());
                }
                return tooBig;
            }
        };
    }

    public void set(String key,String value) {
        cache.put(key,value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        SimpleLRUCache cache = new SimpleLRUCache(3);
        cache.set("1","1");
        cache.set("2","1");
        cache.get("1");
        cache.set("3","1");
        cache.get("1");
        cache.set("4","1");
        cache.get("1");
        cache.set("5","1");
        cache.get("1");
        cache.set("6","1");

    }

}
