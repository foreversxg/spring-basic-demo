package com.example.jdk.basic;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/3
 */
public class HexTest {

    public static void main(String[] args) {
        System.out.println(plus("A","B"));
    }
    private static String plus(String h1,String h2) {
        int i1= Integer.parseInt(h1,16);
        int i2 = Integer.parseInt(h2,16);
        int result = i1 + i2;
        return Integer.toHexString(result);

    }

    private static void test_1() {
        int x = 0X11;
        System.out.println(x);
        System.out.println(Integer.toHexString(23123));
    }

    private static void test_2() {
        int hex = Integer.parseInt("A1",16);
        System.out.println(hex);
    }
}
