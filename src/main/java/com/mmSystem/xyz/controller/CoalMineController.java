package com.mmSystem.xyz.controller;

import com.mmSystem.xyz.common.BaseResponse;
import com.mmSystem.xyz.common.ResultUtils;
import com.mmSystem.xyz.entity.CoalMine;
import com.mmSystem.xyz.service.CoalMineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/coalMine")
public class CoalMineController {

    @Autowired
    private CoalMineService coalMineService;

    /**
     * 添加煤矿
     */
    @PostMapping("/addCoalMine")
    public BaseResponse<String>  addCoalMine(@RequestBody CoalMine coalMine){
        coalMineService.addCoalMine(coalMine);
        return ResultUtils.success("插入成功");
    }

    /**
     * 返回所有煤矿
     */
    @GetMapping("/getAllCoalMine")
    public BaseResponse<List<CoalMine>> getAllCoalMine(){
        return ResultUtils.success(coalMineService.getAllCoalMine());
    }

    /**
     * 批量添加煤矿
     */
    @PostMapping("/addCoalMines")
    public BaseResponse<String> addCoalMines(@RequestBody List<CoalMine> coalMines){
        coalMineService.addCoalMines(coalMines);
        return ResultUtils.success("插入成功");
    }

    /**
     * 修改煤矿信息
     */
    @PostMapping("/updateCoalMine")
    public BaseResponse<String> updateCoalMine(@RequestBody CoalMine coalMine){
        coalMineService.updateById(coalMine);
        return ResultUtils.success("修改成功");
    }

    /**
     * 删除煤矿
     */
    @PostMapping("/deleteCoalMine")
    public BaseResponse<String> deleteCoalMine(@RequestBody CoalMine coalMine){
        coalMineService.updateCoalMineById(coalMine);
        return ResultUtils.success("删除成功");
    }
}
