package com.example.memcache;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.utils.XMemcachedClientFactoryBean;

/**
 * @author shaoxiangen
 * create in 2021/3/12
 */
public class Test {


    public void run() throws Exception {
        XMemcachedClientFactoryBean xmemcachedFactory = new XMemcachedClientFactoryBean();
        xmemcachedFactory.setServers("10.197.112.158:11212 10.197.112.159:11212 10.197.112.162:11212");
        xmemcachedFactory.setConnectionPoolSize(2);
        xmemcachedFactory.setOpTimeout(500);
        MemcachedClient memcachedClient = (MemcachedClient) xmemcachedFactory.getObject();
        memcachedClient.get("");
    }
}
