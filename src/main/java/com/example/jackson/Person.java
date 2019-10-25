package com.example.jackson;

/**
 * @author shaoxiangen
 * Create in 2019/10/16
 */
public class Person {

    @Encrypted
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
