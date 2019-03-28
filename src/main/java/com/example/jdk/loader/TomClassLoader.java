package com.example.jdk.loader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/21
 */
public class TomClassLoader extends URLClassLoader {

    public TomClassLoader(URL[] urls) {
        super(urls, JDKClassLoader.getJDKClassLoader());
    }
}
