package com.example.redis;

import org.springframework.beans.factory.InitializingBean;
import redis.clients.jedis.params.SetParams;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/29
 */
public class RedisLock implements InitializingBean {

    private RedisManager redisManager;

    public static void main(String[] args) throws Exception {
        RedisLock lock = new RedisLock();
        lock.afterPropertiesSet();
        lock.lock("lock_test",1000 * 60);
        lock.lock("lock_test",1000 * 60);
        lock.redisManager.close();
    }

    public boolean lock(String key,long timeout) {
        SetParams setParams = new SetParams().nx().px(timeout);
        long value = System.currentTimeMillis();
        return "OK".equals(redisManager.set(key,String.valueOf(value),setParams));
    }

    public void unlock(String key){
        redisManager.delete(key);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        redisManager = new RedisManager();
        redisManager.afterPropertiesSet();
    }
}
