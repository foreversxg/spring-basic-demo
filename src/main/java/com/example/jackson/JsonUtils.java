package com.example.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author shaoxiangen
 * create in 2019/10/25
 */
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static String toJson(Object obj){
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parse(String second, TypeReference<T> typeref) {
        try {
            return objectMapper.readValue(second,typeref);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
