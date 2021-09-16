package org.com.msb.io;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hj
 * @version 1.0
 * @description: TODO
 * @date 2021/6/26 20:52
 */
public class FileNIO {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\hj\\Desktop\\java\\hello.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 构建通道
        FileChannel channel = fileInputStream.getChannel();

        // 构建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1);
        // 开始读
        int readNum = channel.read(buffer);

        buffer.flip();
        // 为何BufferUnderflowException
        System.out.println((char) buffer.get());
    }
}
