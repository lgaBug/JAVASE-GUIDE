package com.lga.io.nio.Demo;

import com.sun.xml.internal.ws.message.ByteArrayAttachment;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class GroupChatServer {

    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6668;

    public GroupChatServer() {
        try {
            this.selector = Selector.open();
            this.listenChannel = ServerSocketChannel.open();
            this.listenChannel.socket().bind(new InetSocketAddress(PORT));
            listenChannel.configureBlocking(false);
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listen() {

        try {
            while (true) {
                int cout = selector.select();

                if (cout > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        if (selectionKey.isAcceptable()) {
                            SocketChannel sc = listenChannel.accept();
                            sc.configureBlocking(false);
                            sc.register(selector, SelectionKey.OP_READ);
                            System.out.println(sc.getRemoteAddress() + " 已经上线");
                        } else if (selectionKey.isReadable()) {
                            read(selectionKey);
                        }else{
                        }
                    }
                    iterator.remove();

                }else{
                    System.out.println("等待连接......");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void read(SelectionKey key) {
        SocketChannel sc = null;

        try {
            sc= (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int readCount = sc.read(buffer);

            if (readCount > 0) {
                String msg = new String(buffer.array());
                System.out.println("form 客户端的消息：" + msg);

                //向其他channel转发msg
                sendInfoToOtherClients(msg,sc);
            }

        } catch (Exception e) {
            try {
                System.out.println(sc.getRemoteAddress() + "已离线");
                //取消注册
                key.cancel();
                //关闭通道
                sc.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } finally {
        }
    }

    private void sendInfoToOtherClients(String msg, SocketChannel self) {

        try {
            System.out.println("服务器转发消息");
            for (SelectionKey key : selector.keys()) {
                Channel targetChannel = key.channel();
                //排除自己
                if (targetChannel instanceof SocketChannel && targetChannel != self) {
                    SocketChannel dest = (SocketChannel) targetChannel;
                    ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                    dest.write(buffer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }
}
