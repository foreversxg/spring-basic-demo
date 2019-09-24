package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author shaoxiangen
 * @Date create in 2019/8/16
 */
public class BeanUtils {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("./src/main/resources"));
        byte[] data = new byte[fis.available()];
        fis.read(data);

    }
}
