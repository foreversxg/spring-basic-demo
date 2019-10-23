package com.example.net.conn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author shaoxiangen
 * Create in 2019/10/23
 */
public class SocketConnection implements Connection {

    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public SocketConnection(Socket socket) throws IOException {
        this.socket = socket;
        outputStream = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }


    @Override
    public String send(String content) throws IOException {
        Message message = new Message();
        message.setCode(1);
        message.setContent(content);
        outputStream.writeObject(message);
        outputStream.flush();
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public String receive() throws IOException, ClassNotFoundException {
        // 这里会阻塞，直到服务端有数据返回
        inputStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        Message message = (Message) inputStream.readObject();
        System.out.println(message);
        return message.getContent();
    }
}
