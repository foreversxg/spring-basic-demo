package com.example.jdk.jvm;

/**
 * @author shaoxiangen
 * create in 2020/11/25
 */
public class Food {

    private String energy = new String(new byte[1024 * 1023]);

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }
}
