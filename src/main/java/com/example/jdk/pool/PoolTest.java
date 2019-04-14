package com.example.jdk.pool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/2
 */
public class PoolTest {

    public static void main(String[] args) throws Exception {
        ConnectionFactory orderFactory = new ConnectionFactory();
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(5);
        //设置获取连接超时时间
        config.setMaxWaitMillis(1000);
        ConnectionPool connectionPool = new ConnectionPool(orderFactory, config);
        for (int i = 0; i < 7; i++) {
            Connection o = connectionPool.borrowObject();
            System.out.println("brrow a connection: " + o +" active connection:"+connectionPool.getNumActive());
            //connectionPool.returnObject(o);
        }
    }
}
