package com.lga.io.masibing;

import java.io.BufferedWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static com.lga.io.masibing.Utils.*;

// BIO: Block IO 。压测结果为：QPS 2.0。1S等于500ms+500ms,而我们每500ms响应一个请求，所以我们的理论QPS：1+1 = 2.0
public class BIODemo {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT, BACK_LOG, null);
        System.out.println("启动服务器");
        while (true) {
            // 线程阻塞在这里，接收客户端请求
            System.out.println("准备接收客户端请求");
            Socket socket = serverSocket.accept();
            System.out.println("接收到客户端请求：" + socket.getRemoteSocketAddress());
            BufferedWriter bufferedWriter = buildBufferedWriter(socket.getOutputStream());

            // 模拟业务操作
            doSomeWork();

            bufferedWriter.write(buildHttpResp());
            bufferedWriter.flush();
        }
    }
}
