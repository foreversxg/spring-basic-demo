package com.example.net.conn;

import java.io.IOException;

/**
 * @author shaoxiangen
 * Create in 2019/10/23
 */
public interface Connection {

    String send(String message) throws IOException;

    void close();

    String receive() throws IOException, ClassNotFoundException;
}
