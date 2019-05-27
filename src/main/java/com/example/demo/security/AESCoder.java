package com.example.demo.security;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/9
 */
public class AESCoder {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String result = new String(encrypt("Hello world".getBytes("utf-8"),"OjihEKW9Bzcjz9z9"));
        System.out.println(new String(decrypt(result,"OjihEKW9Bzcjz9z9")));
    }

    public static String encrypt(byte[] content, String password) {
        try {
            SecretKeySpec key = new SecretKeySpec(genKey(password), "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            // 初始化，设置为解密模式
            //byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return parseByte2HexStr(result); // 加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] decrypt(String contentStr, String password) {
        try {
            byte[] content = parseHexStr2Byte(contentStr);
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            SecretKeySpec key = new SecretKeySpec(genKey(password), "AES");
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] genKey(String password) throws Exception {
        return password.getBytes("utf-8");
    }

    /**
     * 将二进制转换成16进制
     * Java中byte用二进制表示占用8位，而我们知道16进制的每个字符需要用4位二进制位来表示（23 + 22 + 21 + 20 = 15），
     * 所以我们就可以把每个byte转换成两个相应的16进制字符，即把byte的高4位和低4位分别转换成相应的16进制字符H和L，
     * 并组合起来得到byte转换到16进制字符串的结果new String(H) + new String(L)。即byte用十六进制表示只占2位。
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }



    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
