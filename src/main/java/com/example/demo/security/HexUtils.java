package com.example.demo.security;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/13
 */
public class HexUtils {

    private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String byteToHex(byte[] bytes ) {

        char[] chars = new char[bytes.length * 2];
        int k = 0;
        for(int i=0;i<chars.length;i++) {
            chars[k++] = hexDigits[bytes[i] >>> 4 & 0xf];
            chars[k++] = hexDigits[bytes[i] & 0xf];
        }
        return String.valueOf(chars);
    }


}
