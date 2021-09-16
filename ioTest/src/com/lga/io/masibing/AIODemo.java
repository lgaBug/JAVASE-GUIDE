package com.lga.io.masibing;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

import static com.lga.io.masibing.Utils.*;

/**
 * @author hj
 * @version 1.0
 * @description: 异步网络IO例子
 * @date 2021/5/15 9:53
 */
public class AIODemo {
    public static final CountDownLatch EXIT_LATCH = new CountDownLatch(1);
    public static AsynchronousServerSocketChannel serverSocketChannel;

    public static void createAsynchronousServerSocketChannel(int port) {
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port), BACK_LOG);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {

        @Override
        public void completed(AsynchronousSocketChannel socketChannel, Object attachment) {
            serverSocketChannel.accept(null, this);
            String resp = buildHttpResp();
            try {
                doSomeWork();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            socketChannel.write(ByteBuffer.wrap(resp.getBytes(StandardCharsets.UTF_8)));
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("start aio server");
        createAsynchronousServerSocketChannel(DEFAULT_PORT);
        serverSocketChannel.accept(null, new AcceptHandler());
        // main thread wait exit
        try {
            System.out.println("wait server close");
            EXIT_LATCH.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end aio server");
    }
}
