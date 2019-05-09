package com.example.cache;

import redis.clients.jedis.util.JedisClusterCRC16;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/19
 */
public class Crc16Test {

    public static void main(String[] args) {
        System.out.println(JedisClusterCRC16.getSlot("music_video_user_crc16_test_1"));
        System.out.println(JedisClusterCRC16.getSlot("music_video_user_crc16_test_2"));
        System.out.println(JedisClusterCRC16.getSlot("music_video_user_crc16_test_3"));
        System.out.println(JedisClusterCRC16.getSlot("music_video_user_crc16_test_4"));
        System.out.println(JedisClusterCRC16.getSlot("music_video_user_crc16_test_5"));

    }
}
