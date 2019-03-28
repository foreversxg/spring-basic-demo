package com.example.jdk.loader;

import sun.applet.Main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/21
 */
public class ClassLoadTest extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = getClassFile(name);
        try {
            byte[] bytes = getClassBytes(file);
            return defineClass(name,bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
    private File getClassFile(String name) {
        // return new File(name);
        return new File("D:\\class\\Cat.class");
    }
    private static byte[] getClassBytes(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream aos = new ByteArrayOutputStream(fis.available());
        byte[] bytes = new byte[fis.available()];  //使用fis.avaliable()方法确保整个字节数组没有多余数据
        fis.read(bytes);
        aos.write(bytes);
        fis.close();
        return aos.toByteArray();
    }
    public static void main(String[] args) throws Exception {
        ClassLoadTest ct = new ClassLoadTest();
        Class c = Class.forName("com.example.jdk.loader.Cat", true, ct);
        Class c2 = Class.forName("com.example.jdk.loader.Cat");
        System.out.println(2);
        Animal oject = (Animal)c.newInstance();
        System.out.println(String.class.getClassLoader());
        System.out.println(oject.getName());
        System.out.println(ClassLoadTest.class.getClassLoader());
        System.out.println(c.getClassLoader());
    }
}
