package com.cd.xiaogui.java.io.Nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class QQclient {

    @Test
    public   void client1( ) {
        Socket socket = null;
        try {
             socket = new Socket("127.0.0.1",8080); // 这个socket是和服务端
            socket.getOutputStream().write("123我是在测试啊11111".getBytes());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public   void client2( ) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",8080); // 这个socket是和服务端
            socket.getOutputStream().write("123我是在测试22222".getBytes());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
