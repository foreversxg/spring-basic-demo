package com.example.jdk.loader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/21
 */
public class JerryClassLoader extends URLClassLoader {

    public JerryClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }
}
