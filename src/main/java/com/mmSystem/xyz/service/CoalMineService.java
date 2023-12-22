package com.mmSystem.xyz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mmSystem.xyz.entity.CoalMine;
import com.mmSystem.xyz.entity.CoalMine;
import com.mmSystem.xyz.entity.Sensor;

import java.util.List;

public interface CoalMineService extends IService<CoalMine> {
    /**
     * 添加煤矿
     * @param coalMine
     */
    void addCoalMine(CoalMine coalMine);

    /**
     *返回所有煤矿
     **/
    List<CoalMine> getAllCoalMine();

    /**
     * 更新数据
     * @param coalMine
     */
    void updateCoalMineById(CoalMine coalMine);

    void addCoalMines(List<CoalMine> coalMines);

    /**
     * 模糊搜索
     * @param search
     */
    List<CoalMine> fuzzySearch(String search);
}
