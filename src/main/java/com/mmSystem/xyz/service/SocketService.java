package com.mmSystem.xyz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mmSystem.xyz.entity.SocketData;

import java.util.List;

public interface SocketService extends IService<SocketData> {
    /**
     *  获取所有数据
     * @return
     */
    public List<SocketData> getAllSocketData();

    /**
     *  删除指定id的数据
     * @param id
     */
    public void deleteSocketById(String id);
}
