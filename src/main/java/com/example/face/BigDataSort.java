package com.example.face;

import java.util.Random;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/20
 */
public class BigDataSort {

//    private static final int CAPACITY = 1_000_000;// 数据容量
private static final int CAPACITY = 10;// 数据容量
    public static void main(String[] args) {

        testMyFullBitMap();

    }

    public static void testMyFullBitMap() {
        MyFullBitMap ms = new MyFullBitMap();

        byte[] bytes = null;

        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < CAPACITY; i++) {
            int num = random.nextInt(200);
            // System.out.println("读取了第 " + (i + 1) + "\t个数: " + num);
            bytes = ms.setBit(num);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("存入%d个数，用时%dms\n", CAPACITY, endTime - startTime);

        startTime = System.currentTimeMillis();
        ms.output(bytes);
        endTime = System.currentTimeMillis();
        System.out.printf("取出%d个数，用时%dms\n", CAPACITY, endTime - startTime);
    }
}

class MyFullBitMap {
    // 定义一个byte数组表示所有的int数据，一bit对应一个，共2^32b=2^29B=512MB
    private byte[] dataBytes = new byte[1 << 29];

    /**
     * 读取数据，并将对应数数据的 到对应的bit中，并返回byte数组
     *
     * @param num
     *            读取的数据
     * @return byte数组 dataBytes
     */
    public byte[] setBit(int num) {
        // 加上 (1L << 31)是为了防止负数的出现
        long bitIndex = num + (1L << 31); // 获取num数据对应bit数组（虚拟）的索引
        // 一个byte = 8 bit
        int index = (int) (bitIndex / 8); // bit数组（虚拟）在byte数组中的索引
        int innerIndex = (int) (bitIndex % 8); // bitIndex 在byte[]数组索引index 中的具体位置

        // System.out.println("byte[" + index + "] 中的索引：" + innerIndex);
        // 通过位运算获取byte数组中的位置
        dataBytes[index] = (byte) (dataBytes[index] | (1 << innerIndex));
        return dataBytes;
    }

    /**
     * 输出数组中的数据
     *
     * @param bytes
     *            byte数组
     */
    public void output(byte[] bytes) {
        int count = 0;
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < 8; j++) {
                // 通过位操作get数组中的位置
                if (((bytes[i]) & (1 << j)) != 0) {
                    count++;
                    int number = (int) ((((long) i * 8 + j) - (1L << 31)));
                     System.out.println("取出的第 " + count + "\t个数: " + number);
                }
            }
        }
    }
}
