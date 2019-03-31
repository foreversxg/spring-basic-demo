package com.example.redis;

import org.springframework.beans.factory.InitializingBean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.SetParams;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/29
 */
public class RedisManager implements InitializingBean {

    private JedisPool jedisPool;
    private String host="127.0.0.1";
    private int port=6379;

    @Override
    public void afterPropertiesSet() throws Exception {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setTestOnBorrow(false);
        this.jedisPool = new JedisPool(config, this.host, this.port);
    }

    public String set(String key,String value) {
        return getJedis().set(key,value);
    }

    public String set(String key,String value,SetParams setParams) {
        return getJedis().set(key,value,setParams);
    }

    /**
     *
     * @param key
     * @param value
     * @param expireTime 超时时间 秒
     * @return
     */
    public String setex(String key,String value,int expireTime) {
        return getJedis().setex(key,expireTime,value);
    }


    public String get(String key){
        return getJedis().get(key);
    }

    public Long incr(String key) {
        return getJedis().incr(key);
    }

    /**
     *
     * @param key
     * @return 剩余过期时间
     */
    public Long ttl(String key) {
        return getJedis().ttl(key);
    }

    private Jedis getJedis() {
        try {
            Jedis jedis = this.jedisPool.getResource();
            return jedis;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public void close() {
        jedisPool.close();
    }

    public void delete(String key) {
        getJedis().del(key);
    }
}
