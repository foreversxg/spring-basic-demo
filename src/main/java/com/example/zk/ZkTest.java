package com.example.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.io.UnsupportedEncodingException;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/25
 */
public class ZkTest {

    public static void main(String[] args) throws Exception {
        ZKService zkService = new ZKService("127.0.0.1:2181","");
        String path = "/sxg/test";
        zkService.init();
        zkService.delete(path);
        zkService.add(path,"123");
        PathChildrenCache pathChildrenCache = new PathChildrenCache(zkService.getClient(), path, true);
        pathChildrenCache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                System.out.println("get event" + event);
            }
        });
        zkService.add(path + "/children1","122");
//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3000, 10000);
//
//        CuratorFramework client = CuratorFrameworkFactory.builder().authorization("digest", "".getBytes("utf-8")).retryPolicy(retryPolicy)
//                .connectionTimeoutMs(3000).sessionTimeoutMs(3000).connectString("127.0.0.1:2181").build();
//        client.start();
////        String result = client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/sxg/test", "test".getBytes("utf-8"));
////        System.out.println(result);
//        byte[] value = client.getData().forPath("/sxg/test");
//        System.out.println(new String(value));
    }
}
