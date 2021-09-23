package com.lga.io.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.lga.io.masibing.Utils.buildHttpResp;

public class SelectorDemo01 {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress("127.0.0.1",9999));

        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("服务器已启动");

        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isAcceptable()) {
                    System.out.println("已连接");
                    SocketChannel socketChannel = ssc.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("注册可读监听器");
                } else if (selectionKey.isReadable()) {
                    System.out.println("已进入可读");
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer readBuff = ByteBuffer.allocate(1024);
                    readBuff.clear();
                    int read = 0;
                    while ((read = channel.read(readBuff)) > 0) {
                        while (readBuff.hasRemaining()) {
                            System.out.print((char) readBuff.get());
                        }
                    }
                    readBuff.clear();
                    readBuff.flip();
                    readBuff.put(buildHttpResp().getBytes());
                    channel.write(readBuff);
                }
            }
            iterator.remove();
        }
    }
}
