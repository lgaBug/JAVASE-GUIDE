package com.lga.io.nio.Demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GroupChatClient {

    private static final String HOST = "127.0.0.1";
    private static final Integer PORT = 6668;
    private Selector selector;
    private SocketChannel sc;
    private String userName;

    public GroupChatClient() {
        try {
            selector = Selector.open();
            sc = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            sc.configureBlocking(false);
            sc.register(selector, SelectionKey.OP_READ);
            userName = sc.getLocalAddress().toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void sendInfo(String info) {
        info = userName + "说: " + info;
        try {
            sc.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readInfo() {
        try {
            int count = selector.select();
            if (count > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();

                    if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel)key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.read(buffer);
                        System.out.println("读到了数据："+new String(buffer.array()));
                    }else{
                        System.out.println("没有可用的通道。。。。");
                    }
                }
                iterator.remove();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        GroupChatClient groupChatClient = new GroupChatClient();

        new Thread(() -> {
            while (true) {
                groupChatClient.readInfo();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            groupChatClient.sendInfo(scanner.nextLine());
        }
    }
}
