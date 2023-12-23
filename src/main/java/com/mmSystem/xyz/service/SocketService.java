package com.mmSystem.xyz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mmSystem.xyz.entity.SocketData;

import java.util.List;

public interface SocketService extends IService<SocketData> {
    public List<SocketData> getAllSocketData();

    public void deleteSocketById(String id);
}
