package com.example.jackson;

import com.fasterxml.jackson.databind.util.StdConverter;

/**
 * @author shaoxiangen
 * Create in 2019/10/16
 */
public class EncodeConverter extends StdConverter<String, String> {
    @Override
    public String convert(String str) {
        return str + "abc";
    }
}
