package com.mmSystem.xyz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mmSystem.xyz.dao")
public class Application {

    public static void main(String[] args) {
        // 启动服务
        SpringApplication.run(Application.class, args);
    }
}
