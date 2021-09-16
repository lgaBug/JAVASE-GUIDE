package com.lga.io.nio.channel;

import sun.nio.ch.sctp.SctpServerChannelImpl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

import static com.lga.io.masibing.Utils.buildHttpResp;

public class ServerSocketChannelDemo {


    public static void main(String[] args) throws Exception {

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(8888));
        ssc.configureBlocking(false);

        while (true) {
            SocketChannel sc = ssc.accept();
            try {
                if (sc == null) {
                    System.out.println("11111111");
                    TimeUnit.SECONDS.sleep(3);
                }else{
                    System.out.println("连接进来了,连接来自："+ sc.socket().getRemoteSocketAddress());
                    ByteBuffer buf = ByteBuffer.wrap(buildHttpResp().getBytes());
                    buf.rewind();
                    sc.write(buf);
                }
            }finally {
                if (sc != null) {
                    sc.close();
                }
            }

        }

    }
}
