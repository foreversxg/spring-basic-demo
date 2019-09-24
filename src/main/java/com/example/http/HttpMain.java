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

        BufferedReader br = null;
        InputStream is = null;
        BufferedWriter bw = null;
        int count = 1;
        try {
            is = HttpMain.class.getResourceAsStream("/video.txt");
            br = new BufferedReader(new InputStreamReader(is));
            bw = new BufferedWriter(new FileWriter(new File("D:/ActiveVideo.txt")));
            String line = null;
            while ((line = br.readLine()) != null) {
                if(isActive(line)){
                    bw.write(line + "\n");
//                    Thread.sleep(500);
                    System.out.println(count++);
//                    if(count > 5) {
//                        break;
//                    }
                } else {
                    System.out.println("404 url+++++++++++++++++++");
                }
            }
            bw.flush();;
            bw.close();
        } catch (Exception e) {
        } finally {
            try {
                if(is != null) {
                    is.close();
                }
            } catch (IOException e) {
            }
            try {
                if(br != null) {
                    br.close();
                }
            } catch (IOException e) {
            }
        }

    }

    public static boolean isActive(String videoIdStr) {
//        CloseableHttpClient httpclient=HttpClients.createDefault();
        String[] array = videoIdStr.split("\t");
        HttpGet httpget=new HttpGet("http://" + array[1]);
        try {
            CloseableHttpResponse response=httpclient.execute(httpget);
            String str = "";
            try {
                str = EntityUtils.toString(response.getEntity());
                Body body = JSONObject.parseObject(str,Body.class);
                return body.getCode() == 200;
            } catch (Exception e) {
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
