package com.mmSystem.xyz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mmSystem.xyz.entity.Sensor;
import com.mmSystem.xyz.entity.User;

public interface UserService extends IService<User>{
    /**
     * 通过phoneId超找用户
     * @param phoneId
     */
    User findUserByPhoneId(String phoneId);

    /**
     * 注册用户
     * @param user
     */
    void addUser(User user);

    /**
     * 删除用户
     * @param sensor
     */
    void deleteSensorById(User user);

}
