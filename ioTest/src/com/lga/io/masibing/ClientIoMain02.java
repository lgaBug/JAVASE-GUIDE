package com.lga.io.masibing;

import java.io.IOException;
import java.net.Socket;

public class ClientIoMain02 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",8001);


        socket.getOutputStream().write("2222222222222".getBytes());

    }
}
