package com.lga.io.nio.channel;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DatagramChannelDemo {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        DatagramChannelDemo datagramChannelDemo = new DatagramChannelDemo();

        executorService.execute(() -> {
            datagramChannelDemo.sendDatagram();
        });


        executorService.execute(() -> {
            datagramChannelDemo.recieveDatagram();
        });



    }

    public void sendDatagram() {
        try {
            DatagramChannel sendChannel = DatagramChannel.open();
            InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
            int i = 0;
            while (true) {
                ByteBuffer buf = ByteBuffer.wrap(("999999 ---" + i++).getBytes());
                sendChannel.send(buf, address);
                System.out.println(Thread.currentThread().getName() + "已经完成了发送");
                TimeUnit.SECONDS.sleep(3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void recieveDatagram() {
        try {
            DatagramChannel receiveChannel = DatagramChannel.open();
            InetSocketAddress address = new InetSocketAddress(9999);
            ByteBuffer buf = ByteBuffer.allocate(100);
            receiveChannel.bind(address);

            while (true) {
                TimeUnit.SECONDS.sleep(10);
                buf.clear();
                SocketAddress socketAddress = receiveChannel.receive(buf);
                buf.flip();
                System.out.println("socketAddress.toString() = " + socketAddress.toString());
                System.out.println(Thread.currentThread().getName() + "已经接收了：" + Charset.forName("utf-8").decode(buf));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
