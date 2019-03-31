package com.example.redis;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/29
 */
public class RedisManagerTest {

    private static RedisManager redisManager;

    public static void main(String[] args) throws Exception {
        init();
//        test_setex();
//        test_incr();
        test_setex();
        redisManager.close();
    }

    private static void init() throws Exception {
        redisManager = new RedisManager();
        redisManager.afterPropertiesSet();
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
