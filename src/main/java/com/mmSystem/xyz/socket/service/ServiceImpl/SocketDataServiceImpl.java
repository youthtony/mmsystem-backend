package com.mmSystem.xyz.socket.service.ServiceImpl;// 使用 MyBatis-Plus 的 SocketDataService
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.mmSystem.xyz.entity.Sensor;
import com.mmSystem.xyz.entity.SocketData;
import com.mmSystem.xyz.socket.dao.SocketDataRepository;
import com.mmSystem.xyz.socket.service.SocketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

@Service
public class SocketDataServiceImpl extends ServiceImpl<SocketDataRepository, SocketData> implements SocketDataService {

//    private final SocketDataRepository socketDataRepository;
//
//
//    @Autowired
//    public SocketDataServiceImpl(SocketDataRepository socketDataRepository) {
//        this.socketDataRepository = socketDataRepository;
//    }

    public void startSocketListener(int port) {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                while (true) {
                    Socket socket = serverSocket.accept();
                    processSocketData(socket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void processSocketData(Socket socket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String inputData = reader.readLine();

            // 将 inputData 解析为 SocketData 对象
            // 为简单起见，假设 inputData 是一个 JSON 字符串
            // 你可能需要使用类似 Jackson 或 Gson 的 JSON 库
            SocketData socketData = parseSocketData(inputData);

            // 使用 MyBatis-Plus 将数据保存到数据库
            baseMapper.insert(socketData);
            System.out.println("接收到数据：" + inputData);

            // 在这里执行其他业务逻辑

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SocketData parseSocketData(String inputData) {
        // 解析 JSON 字符串并创建 SocketData 对象
        // 为简单起见，你可以使用 Gson 或 Jackson 这样的 JSON 库
        // 例子（使用 Gson）：
        // return new Gson().fromJson(inputData, SocketData.class);
        return new Gson().fromJson(inputData, SocketData.class);
    }
}
