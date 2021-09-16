package com.lga.io.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {


    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("./fileChannelFile.txt", "rw");
//        write(file,"liugaoandas dsa das ");
        read(file);
    }


    private static void write(RandomAccessFile file,String str) throws IOException {

        FileChannel channel = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(100);
        buf.put(str.getBytes());
        buf.flip();
        while (buf.hasRemaining()) {
            channel.write(buf);
        }
        buf.clear();
        channel.close();
    }


    private static void read(RandomAccessFile file) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(48);
        FileChannel fileChannel = file.getChannel();

        int bytesRead = fileChannel.read(buf);

        while (bytesRead != -1) {
            System.out.println("读取了：" + bytesRead);
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char)buf.get());
            }
            buf.clear();
            bytesRead = fileChannel.read(buf);
        }
        file.close();
    }
}
