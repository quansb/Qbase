package com.quansb.network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author quanshibao
 * @description
 * @date 2020/11/3
 */
public class HttpService implements IService {

    public static final int port = 4000;

    private StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {

        final HttpService service = new HttpService();

        Thread thread = new Thread() {
            @Override
            public void run() {
                service.open();
            }
        };
        thread.start();
    }

    private void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                System.out.println(builder.toString());
                socket.close();
                inputStream.close();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void open() {
        init();
    }

}
