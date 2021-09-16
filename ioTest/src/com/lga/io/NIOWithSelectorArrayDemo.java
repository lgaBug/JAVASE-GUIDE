package org.com.msb.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.com.msb.io.Utils.*;

/**
 * @author hj
 * @version 1.0
 * @description: QPS 4.0
 * @date 2021/5/17 21:30
 */
public class NIOWithSelectorArrayDemo {
    private static final int POLLER_NUM = 2;
    private static Poller[] pollers;

    public static void main(String[] args) throws Exception {
        System.out.println("启动服务器");
        ServerSocketChannel serverSocketChannel = createServerSocketChannel();
        long count = 0;
        int m = pollers.length - 1;
        for (; ; ) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println(socketChannel.getRemoteAddress());
            // 轮询放入poller
            pollers[(int) (count++ & m)].addSocketChannel(socketChannel);
        }
    }


    public static class Poller extends Thread {
        private Selector selector;
        private BlockingQueue<SocketChannel> socketChannelBlockingQueue = new LinkedBlockingQueue<>();
        private AtomicBoolean atomicBoolean = new AtomicBoolean();

        @Override
        public void run() {
            while (true) {
                try {
                    SocketChannel socketChannel = socketChannelBlockingQueue.poll();
                    if (socketChannel != null)
                        handleSocketChannel(socketChannel);
                    atomicBoolean.set(true);
                    selector.select(1000);
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey next = iterator.next();
                        if (next.isWritable())
                            handleWrite(next);
                        iterator.remove();
                    }
                } catch (Exception e) {
                }
            }
        }

        public void handleWrite(SelectionKey next) {
            SocketChannel sc = (SocketChannel) next.channel();
            try {
                sc.write((ByteBuffer) next.attachment());
            } catch (Exception e) {
            }
        }

        public void handleSocketChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.configureBlocking(false);
            doSomeWork();
            String resp = buildHttpResp();
            socketChannel.register(selector, SelectionKey.OP_WRITE, ByteBuffer.wrap(resp.getBytes()));
        }

        public void init() throws IOException {
            selector = Selector.open();
        }

        public void addSocketChannel(SocketChannel socketChannel) {
            try {
                socketChannelBlockingQueue.put(socketChannel);
                if (atomicBoolean.get()) {
                    selector.wakeup();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void init() throws Exception {
        initPoller();
        startPoller();
    }

    public static ServerSocketChannel createServerSocketChannel() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(true);
        serverSocketChannel.bind(new InetSocketAddress(DEFAULT_PORT), BACK_LOG);
        init();
        return serverSocketChannel;
    }

    public static void initPoller() throws IOException {
        pollers = new Poller[POLLER_NUM];
        for (int i = 0; i < pollers.length; i++) {
            Poller poller = new Poller();
            poller.init();
            pollers[i] = poller;
        }
    }

    public static void startPoller() {
        for (int i = 0; i < pollers.length; i++) {
            pollers[i].start();
        }
    }
}
