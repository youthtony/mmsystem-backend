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

    /**
     * 删除数据
     * @param sensor
     */
    void deleteSensorById(Sensor sensor);

    /**
     *  批量添加传感器
     * @param sensors
     */

    void addSensors(List<Sensor> sensors);

    /**
     * 模糊搜索
     * @param search
     */
    List<Sensor> fuzzySearch(String search);

}
