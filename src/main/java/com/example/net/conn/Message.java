package com.example.net.conn;

import java.io.Serializable;

/**
 * @author shaoxiangen
 * Create in 2019/10/23
 */
public class Message implements Serializable {

    private int code;
    private String content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
