package com.lga.io.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {

    public static void main(String[] args)  {

        ByteBuffer buf = ByteBuffer.allocate(100);
        SocketChannel sc = null;
        try {
            sc = SocketChannel.open(new InetSocketAddress(8888));
            sc.configureBlocking(false);
            buf.put("liugaoan".getBytes());
            sc.write(buf);
            buf.clear();
        } catch (Exception e) {

        }finally {
            if (sc != null) {
                try {
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
