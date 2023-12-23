package com.mmSystem.xyz.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mmSystem.xyz.dao.SensorMapper;
import com.mmSystem.xyz.dao.SocketMapper;
import com.mmSystem.xyz.entity.Sensor;
import com.mmSystem.xyz.entity.SocketData;
import com.mmSystem.xyz.entity.User;
import com.mmSystem.xyz.service.SensorService;
import com.mmSystem.xyz.service.SocketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocketServiceImpl extends ServiceImpl<SocketMapper, SocketData>
        implements SocketService {

    @Override
    public List<SocketData> getAllSocketData() {
        return baseMapper.selectList(new QueryWrapper<SocketData>().eq("isDelete",0));
    }

    @Override
    public void deleteSocketById(String id) {
        UpdateWrapper<SocketData> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("isDelete", 1)
                .eq("id", id);
        this.update(updateWrapper);
    }
}
