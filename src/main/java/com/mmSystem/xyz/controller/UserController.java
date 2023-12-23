package com.mmSystem.xyz.controller;

import com.google.gson.Gson;
import com.mmSystem.xyz.common.BaseResponse;
import com.mmSystem.xyz.common.ResultUtils;
import com.mmSystem.xyz.dao.UserMapper;
import com.mmSystem.xyz.entity.User;
import com.mmSystem.xyz.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户Controller
 * @Auther: xiaoyi
 */
@Slf4j
@SuppressWarnings("all")
@RestController
@RequestMapping("/user")
public class UserController {
    private Gson gson = new Gson();
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public BaseResponse<User> Login(@RequestBody User user){
        System.out.println(user.toString());
        User userCheck=userService.findUserByPhoneId(user.getPhoneId());
        if (userCheck== null){
            return ResultUtils.error(1,"用户不存在");
        }
        if (!userCheck.getPassword().equals(user.getPassword())){
            return ResultUtils.error(1,"密码错误");
        }
        return ResultUtils.success(userCheck);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public BaseResponse<User> Register(@RequestBody User user){
        System.out.println(user.toString());
//        判断数据库中是否有这个user
        User userCheck=userService.findUserByPhoneId(user.getPhoneId());
        if (userCheck== null){
//         没有这个user
            userService.addUser(user);
            return ResultUtils.success(user);
        }else {
            return ResultUtils.error(1,"该用户已存在");
        }
    }

    /**
     * 修改用户信息
     * @param user
     */
    @PostMapping("/update")
    public BaseResponse<User> Update(@RequestBody User user){
        userService.updateById(user);
        return ResultUtils.success(user);
    }

    /**
     * 注销
     */
    @PostMapping("/deleteUser")
    public BaseResponse<String> deleteUser(@RequestBody User user){
        userService.deleteSensorById(user);
        return  ResultUtils.success("注销成功");
    }
}
