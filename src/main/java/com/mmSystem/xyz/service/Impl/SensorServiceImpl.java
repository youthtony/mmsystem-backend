package com.mmSystem.xyz.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mmSystem.xyz.dao.SensorMapper;
import com.mmSystem.xyz.dao.UserMapper;
import com.mmSystem.xyz.entity.Sensor;
import com.mmSystem.xyz.entity.User;
import com.mmSystem.xyz.service.SensorService;
import com.mmSystem.xyz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SensorServiceImpl extends ServiceImpl<SensorMapper, Sensor>
        implements SensorService {

    @Override
    public void addSensor(Sensor sensor) {
        baseMapper.insert(sensor);
    }

    @Override
    public List<Sensor> getAllSensor() {
        return baseMapper.selectList(new QueryWrapper<Sensor>().eq("isDelete",0));
    }

    @Override
    public void addSensors(List<Sensor> sensors) {
        for (Sensor sensor :
                sensors) {
            baseMapper.insert(sensor);
        }
    }

    @Override
    public List<Sensor> fuzzySearch(String search) {
        QueryWrapper<Sensor> wrapper = new QueryWrapper<>();
        wrapper.like("sensorName", search)
                .or()
                .like("sensorType", search)
                .or()
                .like("sensorManufacturer", search);

        return baseMapper.selectList(wrapper);
    }

    @Override
    public void deleteSensorById(Sensor sensor) {
        UpdateWrapper<Sensor> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("isDelete", 1)
                .eq("Id", sensor.getId());
        this.update(updateWrapper);
    }

}
