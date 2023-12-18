package com.mmSystem.xyz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mmSystem.xyz.entity.Sensor;

import java.util.List;

public interface SensorService extends IService<Sensor> {
    /**
     * 添加传感器
     * @param sensor
     */
    void addSensor(Sensor sensor);

    /**
     *返回所有传感器
     **/
    List<Sensor> getAllSensor();

    void addSensors(List<Sensor> sensors);

}
