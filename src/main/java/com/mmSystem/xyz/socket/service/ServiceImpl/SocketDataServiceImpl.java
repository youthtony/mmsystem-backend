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


    // 创建一个ServerSocket，监听端口
public void startSocketListener(int port) {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                while (true) {
                  Socket socket = serverSocket.accept();
                    // 处理客户端发送的数据
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
        return new Gson().fromJson(inputData, SocketData.class);
    }
}
