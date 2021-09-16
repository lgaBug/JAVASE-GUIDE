package org.com.msb.io;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

import static org.com.msb.io.Utils.*;

/**
 * @author hj
 * @version 1.0
 * @description: 使用线程池来并行处理客户端请求，QPS压测为：131  预算：100个线程 * 2 = 200QPS
 * 因为CPU个数不等于线程数，会造成线程频繁切换，导致性能下降
 * @date 2021/5/17 21:07
 */
public class BIOWithTPEDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT, BACK_LOG, null);
        System.out.println("启动服务器");
        ThreadPoolExecutor threadPoolExecutor = buildThreadPoolExecutor();
        for (; ; ) {
            Socket socket = serverSocket.accept();

            threadPoolExecutor.execute(() -> {
                OutputStream outputStream;
                BufferedWriter bufferedWriter;
                try {
                    System.out.println(socket.getRemoteSocketAddress());
                    outputStream = socket.getOutputStream();
                    bufferedWriter = buildBufferedWriter(outputStream);
                    doSomeWork();
                    bufferedWriter.write(buildHttpResp());
                    bufferedWriter.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
