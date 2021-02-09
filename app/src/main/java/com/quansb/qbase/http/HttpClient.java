package com.quansb.qbase.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author quanshibao
 * @description
 * @date 2020/11/3
 */
public class HttpClient {

    public HttpClient() {

    }

    private void init() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    SocketAddress socketAddress = InetSocketAddress.createUnresolved("192.168.2.17", 4000);
                    Socket socket = new Socket("192.168.2.194", 4000);
                    String message = "hello";
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(message.getBytes("UTF-8"));
                    outputStream.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void get() {
        init();
    }


}
