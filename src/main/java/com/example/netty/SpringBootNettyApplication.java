package com.example.netty;

import com.example.netty.config.NettyConfig;
import com.example.netty.server.NettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class SpringBootNettyApplication implements CommandLineRunner {

    @Autowired
    private NettyServer nettyServer;

    private static final Logger logger = LoggerFactory.getLogger(SpringBootNettyApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(SpringBootNettyApplication.class, args);
    }

    /**
     * 重载自 CommandLineRunner
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("Netty's ws server is listen: " + NettyConfig.SOCKET_HOST);
        InetSocketAddress address = new InetSocketAddress(NettyConfig.SOCKET_HOST, NettyConfig.SOCKET_PORT);
        nettyServer.start(address);
    }
}
