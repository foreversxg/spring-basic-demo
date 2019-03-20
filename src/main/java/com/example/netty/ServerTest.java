package com.example.netty;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/7/31
 */
public class ServerTest {

    public static void main(String[] args) {
        NettyServer server = new NettyServer();
        server.init();
        server.start();
    }
}
