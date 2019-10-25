package com.example.net.conn;

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
    private final ObjectInputStream inputStream;
    private final ObjectOutputStream outputStream;

    public SocketConnection(Socket socket) throws IOException {
        this.socket = socket;
        outputStream = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        inputStream = new ObjectInputStream(socket.getInputStream());

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
    public void close() throws IOException {
        inputStream.close();
        outputStream.close();
        socket.close();
    }

    @Override
    public String receive() throws IOException, ClassNotFoundException {
        Message message = (Message) inputStream.readObject();
        System.out.println(message);
        return message.getContent();
    }
}
