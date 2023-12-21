package com.mmSystem.xyz.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName(value = "sensor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 传感器名称
     */
    private String sensorName;

    /**
     * 传感器类型
     */
    private String sensorType;

    /**
     * 传感器生产厂商
     */
    private String sensorManufacturer;

    /**
     * 传感器出产日期
     */
    private Date sensorDate;

    /**
     * 使用年限
     */
    private int sensorLife;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
