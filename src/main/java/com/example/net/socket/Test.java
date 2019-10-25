package com.example.net.socket;

import com.example.net.conn.Connection;
import com.example.net.conn.SocketConnection;

import java.io.IOException;
import java.net.Socket;

/**
 * @author shaoxiangen
 * Create in 2019/10/23
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1",8080);
        Connection conn = new SocketConnection(socket);
        conn.send("hello");
        conn.receive();
    }
}
