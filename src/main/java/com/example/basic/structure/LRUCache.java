package com.example.basic.structure;

import java.util.Map;

public class LRUCache<K,V> {
    private long maxSize;
    private Entry<K,V> head;
    private Entry<K,V> tail;
    private Map<K,Entry<K,V>> cache;

    public void put(K key,V value) {
        Entry<K,V> entry = cache.get(key);
        if(entry == null) {

        } else {
            entry.value = value;

        }
    }

    private void moveToHead(Entry<K,V> entry) {

        if(head == null) {
            head = tail = entry;
            return;
        }
        if(entry == head) {
            return;
        }
        if(entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if(entry.next != null) {
            entry.next.pre = entry.pre;
        }
//        if(entry == tail) {
//            Entry<K,V> temp = entry.pre;
//            if(temp != null) {
//                tail.pre = null;
//                tail = temp;
//                tail.next = null;
//            }
//        }
        entry.next = head;
        head.pre = entry;
        entry.pre = null;
        head = entry;

    }

    private static class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> pre;
        Entry<K,V> next;
    }


}
