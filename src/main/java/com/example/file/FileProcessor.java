package com.example.file;

import com.example.jackson.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.integration.support.json.JacksonJsonUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author shaoxiangen
 * Create in 2019/10/25
 */
public class FileProcessor {

    public static void main(String[] args) {
        File file = new File("/Users/shaoxiangen/music-space/github/spring-basic-demo/src/main/resources/test.log");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null){
                if(line.contains("ElementBackendController update start")) {
                    String[] arrays = line.split("params:");
                    String time = arrays[0].substring(0,23);
                    Date date = parseDate(time);
                    String body = arrays[1];
                    if(body .length() <= 100) {
                        continue;
                    }
                    LogMetaWrapper wrapper = new LogMetaWrapper();
                    wrapper.setDate(date);
                    LogMeta logMeta = parseLogMeta(body);
                    wrapper.setLogMeta(logMeta);
                    if(CollectionUtils.isEmpty(wrapper.getLogMeta().getParams())) {
                        continue;
                    }
                    String println = JsonUtils.toJson(wrapper);
                    System.out.println(println);

//                    System.out.println(arrays[1]);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static LogMeta parseLogMeta(String body) {
        int index = body.indexOf(",[");
        String first = body.substring(0,index);
        LogMeta logMeta = new LogMeta();
        serFirst(first,logMeta);
        String second = body.substring(index+1,body.length());
        setSecond(second,logMeta);

        return logMeta;
    }

    private static void setSecond(String second, LogMeta logMeta) {

        List<UpdateParams> lists = JsonUtils.parse(second, new TypeReference<List<UpdateParams>>() {
        });
        logMeta.setParams(lists.stream().filter(p -> p.getType() == 4).collect(Collectors.toList()));
    }

    private static void serFirst(String first, LogMeta logMeta) {
        String[] results = first.split(",");
        logMeta.setId(Long.valueOf(results[0].trim()));
        logMeta.setConfirm(Boolean.valueOf(results[1].trim()));
        if(results.length > 2) {
            logMeta.setScore(Integer.valueOf(results[2].trim()));
        } else {
            logMeta.setScore(60);
        }
    }

    private static Date parseDate(String time) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(time);
    }
}
