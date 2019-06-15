package com.example.cache.redis;

import org.springframework.beans.factory.InitializingBean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.params.SetParams;

import java.util.List;
import java.util.Set;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/29
 */
public class RedisManager implements InitializingBean {

    private JedisPool jedisPool;
    private String host="127.0.0.1";
    private int port=6379;
    private static ThreadLocal<Jedis> threadLocal = new ThreadLocal<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(30);
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
     * 线上禁用
     * @param pattern
     * @return
     */
    @Deprecated
    public Set<String> keys(String pattern) {
        return getJedis().keys(pattern);
    }

    public List<String> scan(String cursor){
        return getJedis().scan(cursor).getResult();
    }

    public long sadd(String key,String... values) {
        return getJedis().sadd(key,values);
    }

    public Set<String> sMember(String key) {
        return getJedis().smembers(key);
    }

    public boolean ismember(String key,String value) {
        return getJedis().sismember(key,value);
    }

    public List<String> scan(String cursor, final ScanParams params){
        return getJedis().scan(cursor,params).getResult();
    }

    /**
     *
     * @param key
     * @return 剩余过期时间
     */
    public Long ttl(String key) {
        return getJedis().ttl(key);
    }

    public Jedis getJedis() {
        Jedis jedis = threadLocal.get();
        if(jedis != null) {
            return jedis;
        }
        try {
            jedis = this.jedisPool.getResource();
            threadLocal.set(jedis);
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

    public List<String> mulGet(String... keys) {
        return getJedis().mget(keys);
    }


}
