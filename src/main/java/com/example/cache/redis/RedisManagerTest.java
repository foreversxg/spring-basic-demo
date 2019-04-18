package com.example.cache.redis;

import redis.clients.jedis.ScanParams;

import java.util.List;
import java.util.Set;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/29
 */
public class RedisManagerTest {

    private static RedisManager redisManager;

    public static void main(String[] args) throws Exception {
        init();
        redisManager.getJedis().flushAll();
//        test_setex();
//        test_incr();
//        test_scan();

        test_sadd();
        redisManager.close();
    }

    private static void init() throws Exception {
        redisManager = new RedisManager();
        redisManager.afterPropertiesSet();
    }

    private static void test_sadd() {

        redisManager.sadd("test_sadd_1","5","3","1","2","4","3");
        Set<String> set = redisManager.sMember("test_sadd_1");
        set.forEach(System.out::println);


    }

    private static void test_scan() {
        redisManager.setex("test_keys_1","10",10);
        redisManager.setex("test_keys_2","20",10);
        redisManager.setex("test_keys_3","30",10);
        redisManager.setex("test_keys_4","40",10);
        redisManager.setex("test_keys_5","10",10);
        redisManager.setex("test_keys_6","20",10);
        redisManager.setex("test_keys_7","30",10);
        redisManager.setex("test_keys_8","40",10);
        // hash结构  entry + list
        List<String> list = redisManager.scan("0",new ScanParams().count(5));
        list.forEach(System.out::println);
        System.out.println();
        list = redisManager.scan("1",new ScanParams().count(2));
        list.forEach(System.out::println);
    }

    private static void test_keys() {
        redisManager.setex("test_keys_1","10",10);
        redisManager.setex("test_keys_2","20",10);
        redisManager.setex("test_keys_3","30",10);
        redisManager.setex("test_keys_4","40",10);
        Set<String> set = redisManager.keys("*");
        set.forEach(System.out::println);
    }

    private static void test_incr() {
        redisManager.set("test_incr_1","10");
        System.out.println(redisManager.incr("test_incr_1"));
        System.out.println(redisManager.incr("test_incr_1"));
    }
    private static void test_setex() throws InterruptedException {
        redisManager.setex("test_setex_1","6",2);
        System.out.println("立即查找test_setex_1:" + redisManager.get("test_11"));
        Thread.sleep(2000);
        System.out.println("2秒后查找test_setex_1:" + redisManager.get("test_11"));
    }


    private static void test_ttl() throws InterruptedException {
        redisManager.setex("test_12","6",20);
        System.out.println(redisManager.ttl("test_12"));
        Thread.sleep(2000);
        System.out.println("未过期的key：" + redisManager.ttl("test_12"));
        redisManager.set("test_ttl_2","6");
        System.out.println("已过期的key：" + redisManager.ttl("test_ttl_2"));
        System.out.println("不存在的key：" + redisManager.ttl("test_ttl_3"));
    }


}
