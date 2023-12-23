package com.mmSystem.xyz.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mmSystem.xyz.dao.UserMapper;
import com.mmSystem.xyz.entity.Sensor;
import com.mmSystem.xyz.entity.User;
import com.mmSystem.xyz.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Override
    public User findUserByPhoneId(String phoneId) {
//        通过sql语句查找user
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//               设置查询条件
        queryWrapper.eq("phoneId",phoneId);
//                通过mybatis-plus 查询
        User user = this.getOne(queryWrapper);
        return user;
    }

    @Override
    public void addUser(User user) {
        baseMapper.insert(user);
    }

    @Override
    public void deleteSensorById(User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("isDelete", 1)
                .eq("id", user.getId());
        this.update(updateWrapper);
    }

}
