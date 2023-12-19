package com.mmSystem.xyz.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@TableName(value = "coalmine")
@Data
@Builder
public class CoalMine {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 煤矿名称
     */
    private String coalMineName;

    /**
     * 煤矿所属单位
     */
    private String coalMineUnit;

    /**
     * 煤矿使用年限
     */
    private String coalMineLife;

    /**
     * 煤矿监管单位
     */
    private String coalMineSupervisionUnit;

    /**
     * 煤矿地址
     */
    private String coalMineAddress;

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
