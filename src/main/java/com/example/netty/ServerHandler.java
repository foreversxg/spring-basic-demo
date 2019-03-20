package com.example.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/7/31
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("client response :"+s);
        channelHandlerContext.channel().writeAndFlush("i am server !");
    }
}
