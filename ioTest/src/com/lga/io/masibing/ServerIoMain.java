package com.lga.io.masibing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerIoMain {

    static  byte[] bytes = new byte[1024];
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8001);

        System.out.println("服务器已经启动。。。。。");
        while (true){
            Socket accept = serverSocket.accept();

            System.out.println("客户端链接服务器");

            int read = accept.getInputStream().read(bytes);

            System.out.println("接收到了客户端发来的消息"+new String(bytes));

        }



    }
}
