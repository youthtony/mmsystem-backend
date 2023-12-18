package com.mmSystem.xyz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mmSystem.xyz.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
