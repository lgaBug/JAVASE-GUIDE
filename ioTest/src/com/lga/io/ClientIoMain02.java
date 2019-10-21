package com.lga.io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientIoMain {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",8001);


        socket.getOutputStream().write("hello".getBytes());

    }
}
