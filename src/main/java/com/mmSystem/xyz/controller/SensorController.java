package com.mmSystem.xyz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmSystem.xyz.common.BaseResponse;
import com.mmSystem.xyz.common.ResultUtils;
import com.mmSystem.xyz.entity.Sensor;
import com.mmSystem.xyz.service.SensorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    /**
     * 添加传感器
     */
    @PostMapping("/addSensor")
    public BaseResponse<String>  addSensor(@RequestBody Sensor sensor){
        sensorService.addSensor(sensor);
        return ResultUtils.success("插入成功");
    }

    /**
     * 返回所有传感器
     */
    @GetMapping("/getAllSensor")
    public BaseResponse<List<Sensor>> getAllSensor(){
        return ResultUtils.success(sensorService.getAllSensor());
    }

    /**
     * 批量添加传感器
     */
    @PostMapping("/addSensors")
    public BaseResponse<String> addSensors(@RequestBody List<Sensor> sensors){
        sensorService.addSensors(sensors);
        return ResultUtils.success("插入成功");
    }

    /**
     * 修改传感器信息
     */
    @PostMapping("/updateSensor")
    public BaseResponse<String> updateSensor(@RequestBody Sensor sensor){
        sensorService.updateById(sensor);
        return ResultUtils.success("修改成功");
    }

    /**
     * 删除传感器
     */
    @PostMapping("/deleteSensor")
    public BaseResponse<String> deleteSensor(@RequestBody Sensor sensor){
        sensorService.updateSensorById(sensor);
        return ResultUtils.success("删除成功");
    }

    /**
     * 模糊搜索
     */
    @PostMapping("/searchSensor")
    public BaseResponse<List<Sensor>> searchSensor(@Param("search") String search){
        return ResultUtils.success(sensorService.fuzzySearch(search));
    }
}
