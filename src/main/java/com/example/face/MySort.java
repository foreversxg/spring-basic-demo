package com.example.face;

import java.util.Random;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/20
 */
public class MySort {

    public static void main(String[] args) {
        int count = 100000000;
        BitMap bitMap = new BitMap();
        Random random = new Random();
        long time1 = System.currentTimeMillis();
        for(int i = 0;i < count;i++) {
            bitMap.add(random.nextInt(100000000));
        }
        System.out.println("添加数据耗时：" + (System.currentTimeMillis() - time1));
        long time2 = System.currentTimeMillis();
        bitMap.outPut();
        System.out.println("排序数据耗时：" + (System.currentTimeMillis() - time2));
    }

    static class BitMap {

        byte[] bytes;

        public BitMap() {
            this.bytes = new byte[1 << 29];
        }

        public void add(int num) {
            int arrayIndex = num / 8 ;
            int byteIndex = num % 8;
            bytes[arrayIndex] = (byte)(bytes[arrayIndex] | (1 << byteIndex));
//            System.out.println("add :" + num);
        }

        public void outPut(){
            for(int i= 0;i<bytes.length;i++) {
                for(int j = 0; j < 8;j ++) {
                    if(((bytes[i] ) & (1 << j)) != 0) {
                        System.out.println((i * 8) + j);
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                System.out.println("我是修改后的代码");
            }
        }
    }
}
