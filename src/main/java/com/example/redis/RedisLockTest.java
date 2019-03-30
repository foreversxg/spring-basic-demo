package com.example.redis;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/30
 */
public class RedisLockTest {

    private RedisLock redisLock;

    public static void main(String[] args) throws Exception {
        RedisLockTest test = new RedisLockTest();
        test.init();
        Thread thread1 = new Thread(() -> {
            boolean ret = test.redisLock.lock("lock",10*1000);
            if(ret) {
                System.out.println("thread 1 get the lock");
            }
            boolean ret2 = test.redisLock.lock("lock",10*1000);
            if(ret2) {
                System.out.println("thread 1 重入");
            }
        });
        Thread thread2 = new Thread(() -> {
            boolean ret = test.redisLock.lock("lock",10*1000);
            if(ret) {
                System.out.println("thread 2 get the lock");
            }
        });
        thread1.start();
        thread2.start();
    }

    public void init() throws Exception {
        redisLock = new RedisLock();
        redisLock.afterPropertiesSet();
    }
}
