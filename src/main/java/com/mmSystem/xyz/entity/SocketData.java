package com.mmSystem.xyz.entity;// 使用 JPA 注解的 SocketData 实体类
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@TableName(value = "socketData")
public class SocketData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @TableField(value = "gasConcentration")
    private double gasConcentration;

    @TableField(value = "waterLevel")
    private double waterLevel;

    @TableField(value = "temperature")
    private double temperature;

    @CreatedDate
    @Column(name = "createTime", updatable = false)
    private Date createTime;

    @LastModifiedDate
    @Column(name = "updateTime")
    private Date updateTime;

    @Column(name = "isDelete")
    private Integer isDelete;

    // 获取器和设置器
}
