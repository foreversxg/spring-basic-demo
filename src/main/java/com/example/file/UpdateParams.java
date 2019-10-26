package com.example.file;

/**
 * @author shaoxiangen
 * create in 2019/10/25
 */
public class UpdateParams {
    private String value;
    private int source;
    private long id;
    private int type;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
