package com.example.jdk.loader;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @date Created in 2018/8/6
 */
public final class JDKClassLoader extends URLClassLoader {

    private static final JDKClassLoader INSTANCE = newInstance();

    private JDKClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public static final JDKClassLoader getJDKClassLoader() {
        return INSTANCE;
    }

    private static final JDKClassLoader newInstance() {
        ClassLoader systemClassloader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassloader = systemClassloader;
        while (extClassloader.getParent() != null) {
            extClassloader = extClassloader.getParent();
        }
        List<URL> jdkUrls = new ArrayList<>();
        try {
            String javaHome = System.getProperty("java.home").replace(File.separator + "jre", "");
            URL[] urls = ((URLClassLoader) systemClassloader).getURLs();
            for (URL url : urls) {
                if (url.getPath().startsWith(javaHome)) {
                    jdkUrls.add(url);
                }
            }
        } catch (Throwable e) {
            e.printStackTrace(System.err);
        }
        return new JDKClassLoader(jdkUrls.toArray(new URL[0]), extClassloader);
    }

}
