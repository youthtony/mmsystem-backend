package com.mmSystem.xyz.controller;

import com.mmSystem.xyz.common.BaseResponse;
import com.mmSystem.xyz.common.ResultUtils;
import com.mmSystem.xyz.entity.SocketData;
import com.mmSystem.xyz.service.SocketService;
import com.mmSystem.xyz.service.UserService;
import com.mmSystem.xyz.socket.service.SocketDataService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/socket")
public class SocketDataController {

    @Autowired
    private SocketService socketService;

    /**
     * 获取所有socket数据
     */
    @GetMapping("/getAllSocketData")
    public BaseResponse<List<SocketData>> getAll() {
        return ResultUtils.success(socketService.getAllSocketData());
    }

    /**
     * 删除
     */
    @PostMapping("/deleteSocketData")
    public BaseResponse<String> delete(@Param("id") String id) {
        socketService.deleteSocketById(id);
        return ResultUtils.success("删除成功");
    }
}
