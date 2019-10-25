package com.example.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/12/26
 */
public class HttpMain {

    static   CloseableHttpClient httpclient=HttpClients.createDefault();

    public static void main(String[] args) {

        isActive();
    }

    public static boolean isActive() {
//        CloseableHttpClient httpclient=HttpClients.createDefault();
        HttpGet httpget=new HttpGet("http://qa-book.ks.163.com/api/middle/official/accompany/list?id=12");
        try {
            CloseableHttpResponse response=httpclient.execute(httpget);
            String str = "";
            try {
                str = EntityUtils.toString(response.getEntity());
                System.out.println(str);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static class Body{
        private int code;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
