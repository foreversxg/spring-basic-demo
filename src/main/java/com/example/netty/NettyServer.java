package com.example.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/7/31
 */
public class NettyServer {

    private EventLoopGroup boss = new NioEventLoopGroup();
    private EventLoopGroup worker = new NioEventLoopGroup();
    private ServerBootstrap bootstrap = new ServerBootstrap();


    public void init() {
        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        //获取管道
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        //字符串解码器
                        pipeline.addLast(new StringDecoder());
                        //字符串编码器
                        pipeline.addLast(new StringEncoder());
                        //处理类
                        pipeline.addLast(new ServerHandler());
                    }
                    //设置TCP参数
                    //1.链接缓冲池的大小（ServerSocketChannel的设置）
                }).option(ChannelOption.SO_BACKLOG, 1024)
                //维持链接的活跃，清除死链接(SocketChannel的设置)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                //关闭延迟发送
                .childOption(ChannelOption.TCP_NODELAY, true);
    }

    public void start() {
        try {
            bootstrap.bind(8080).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
