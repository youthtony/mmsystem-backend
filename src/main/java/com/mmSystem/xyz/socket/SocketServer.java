package com.mmSystem.xyz.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {
        int port = 8082; // 你的端口号

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String jsonData = reader.readLine();
            System.out.println("来自Socket发送端的数据: " + jsonData);

            // 在这里处理接收到的JSON数据，可以进行解析和业务逻辑处理

            // 返回响应给客户端，可以根据需要返回特定的响应
            socket.getOutputStream().write("Data received successfully".getBytes());

            // 关闭连接
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
