package com.example.netty.client;

/**
 * 模拟多客户端发送报文
 */
public class TestNettyClient {
    public static void main(String[] args) {
        // 开启10条线程，每条线程就相当于一个客户端
        for (int i = 1; i <= 3; i++) {
            new Thread(new NettyClient("thread" + "--" + i)).start();
        }
    }
}
