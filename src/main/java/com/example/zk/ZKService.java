package com.example.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.io.UnsupportedEncodingException;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/25
 */
public class ZKService {

    private CuratorFramework client;
    private String address;
    private String digest;

    public ZKService(String address,String digest){
        this.address = address;
        this.digest = digest;
    }

    public void init() throws UnsupportedEncodingException {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3000, 10000);
        client = CuratorFrameworkFactory.builder().authorization("digest", digest.getBytes("utf-8")).retryPolicy(retryPolicy)
                .connectionTimeoutMs(3000).sessionTimeoutMs(3000).connectString(address).build();
        client.start();
    }

    public boolean add(String path,String value) {
        try {
            client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path, value.getBytes("utf-8"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String get(String path) {
        try {
            byte[] value = client.getData().forPath("/sxg/test");
            return new String(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(String path) {
        try {
            this.client.delete().guaranteed().forPath(path);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public CuratorFramework getClient() {
        return client;
    }

    public String getAddress() {
        return address;
    }

    public String getDigest() {
        return digest;
    }
}
