package com.mmSystem.xyz;

import com.mmSystem.xyz.socket.service.ServiceImpl.SocketDataServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.mmSystem.xyz.dao")
@EnableAsync
public class Application implements CommandLineRunner {
    private final SocketDataServiceImpl socketDataService;

    @Autowired
    public Application(SocketDataServiceImpl socketDataService) {
        this.socketDataService = socketDataService;
    }

    public static void main(String[] args) {
        // 启动服务
        SpringApplication.run(Application.class, args);
    }
    @Override
    public void run(String... args) {
        // 启动Socket监听
        socketDataService.startSocketListener(8082);
    }
}
