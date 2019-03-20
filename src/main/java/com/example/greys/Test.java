package com.example.greys;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/5/24
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> urls = loader.getResources("META-INF/spring.factories");
        System.out.println(urls);
        MultiValueMap<String, String> result = new LinkedMultiValueMap<>();
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            UrlResource resource = new UrlResource(url);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            for (Map.Entry<?, ?> entry : properties.entrySet()) {
                List<String> factoryClassNames = Arrays.asList(
                        StringUtils.commaDelimitedListToStringArray((String) entry.getValue()));
                result.addAll((String) entry.getKey(), factoryClassNames);
            }
        }
    }
}
