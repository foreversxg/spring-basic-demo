package com.example.jdk.file;

import java.io.*;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/5
 */
public class FilteTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/test.txt");
        InputStream in = new FileInputStream(file);
        byte[] buf = new byte[1024]; //数据中转站 临时缓冲区
        int length = 0;
        while((length = in.read(buf)) != -1){
            System.out.println(new String(buf, 0, length));
        }
    }
}
