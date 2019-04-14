package com.example.jdk.pool;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/2
 */
public class Connection {
    private int id;

    public Connection(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "id=" + id +
                '}';
    }
}
