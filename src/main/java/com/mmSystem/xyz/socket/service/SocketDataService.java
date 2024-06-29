package com.mmSystem.xyz.socket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mmSystem.xyz.entity.SocketData;
import com.mmSystem.xyz.socket.dao.SocketDataRepository;

import java.util.List;

public interface SocketDataService extends IService<SocketData> {
    /**
     *  启动Socket监听
     * @param port
     */
    public void startSocketListener(int port);

}
