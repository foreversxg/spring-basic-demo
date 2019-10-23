package com.example.net.socket;

import com.example.net.conn.Message;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shaoxiangen
 * Create in 2019/10/23
 */
public class Server {

    private ServerSocket serverSocket;

    public static void main(String[] args) {
        System.out.println("start");
        Server server = new Server();
        server.init();
        server.start();
    }

    public void init(){
        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            Socket accept = serverSocket.accept();
            System.out.println("rev");
            ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(accept.getOutputStream()));
            Message message = new Message();
            message.setCode(200);
            message.setContent("nihao");
            outputStream.writeObject(message);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
