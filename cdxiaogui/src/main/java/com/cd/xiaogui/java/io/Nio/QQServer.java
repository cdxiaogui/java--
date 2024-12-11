package com.cd.xiaogui.java.io.Nio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class QQServer {

    static byte[] bytes = new byte[1024];

    private static List<Socket> socketList = new ArrayList<Socket>();
    private static List<SocketChannel> socketChannels = new ArrayList<SocketChannel>();
    private static ByteBuffer byteBuffer = ByteBuffer.allocate(512); // 这里是堆外内存

    public static void main(String[] args) {

        try {
            System.out.println("server start ===========");
            ServerSocket serversocket = new ServerSocket(); // 这个socket对象 是来监听的
            serversocket.bind(new InetSocketAddress(8080));
            while (true){
                System.out.println("等待连接中");
                // 这里会阻塞  阻塞等连接
                Socket socket = serversocket.accept(); // 这个socket对象 是有客户端链接的时候，返回的一个对象，和客户端通信的
                // 读取数据流，这里也会阻塞，阻塞读数据 ;read表示读了多少数据
                System.out.println("连接成功了");
                int read = socket.getInputStream().read(bytes);
                while (read != -1 ){ // 没有数据
                    System.out.println("数据接受成功了");
                    System.out.println(read+ " : " + new String(bytes));
                    read = socket.getInputStream().read(bytes);
                }

            }
        }catch (Exception e){

        }
    }

    @Test
    public  void socketServer002() {

        try {
            System.out.println("server start ===========");
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false); // 设置为非阻塞

            while(true){
//                System.out.println("等待连接中");
                // 这里就不会阻塞了
                SocketChannel socketChannel = serverSocketChannel.accept(); // 这个socket对象 是有客户端链接的时候，返回的一个对象，和客户端通信的
                if(socketChannel == null){
//                    System.out.println("无连接");
                    handleData();
                }else{
                    socketChannel.configureBlocking(false); // 先设置为非阻塞
                    socketChannels.add(socketChannel);
                    handleData();
                }
            }
        }catch (Exception e){

        }
    }

    private void handleData() {
        socketChannels.stream().forEach(client -> {
            try {
                // 读取数据流，这里也会阻塞，阻塞读数据 ;read表示读了多少数据
                int read = client.read(byteBuffer);
                while (read != 0 ){ // 没有数据
                    System.out.println("数据接受成功了");
//                    System.out.println(read+ " : " +  charset.byteBuffer.toString());
                    read = client.read(byteBuffer);
                }
            }catch (Exception e){
                log.error("读数据发生错误 ", e);
            }

        });
    }
}
