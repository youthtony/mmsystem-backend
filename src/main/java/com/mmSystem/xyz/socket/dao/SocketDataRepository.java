package com.mmSystem.xyz.socket.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmSystem.xyz.entity.SocketData;
import org.springframework.stereotype.Repository;

@Repository
public interface SocketDataRepository extends BaseMapper<SocketData> {
    // 可以自定义一些其他的查询方法，但不需要定义insert等基本的操作，BaseMapper已经包含这些方法
}