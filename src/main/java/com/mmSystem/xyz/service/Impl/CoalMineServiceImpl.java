package com.mmSystem.xyz.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mmSystem.xyz.dao.CoalMineMapper;
import com.mmSystem.xyz.entity.CoalMine;
import com.mmSystem.xyz.service.CoalMineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoalMineServiceImpl extends ServiceImpl<CoalMineMapper, CoalMine>
        implements CoalMineService {
    /**
     * 添加煤矿
     * @param coalMine
     */
    @Override
    public void addCoalMine(CoalMine coalMine) {
        baseMapper.insert(coalMine);
    }

    /**
     * 获取所有煤矿
     * @return
     */
    @Override
    public List<CoalMine> getAllCoalMine() {
        return baseMapper.selectList(new QueryWrapper<CoalMine>().eq("isDelete",0));
    }
    /**
     * 批量添加煤矿
     */
    @Override
    public void addCoalMines(List<CoalMine> coalMines) {
        for (CoalMine coalMine :
                coalMines) {
            baseMapper.insert(coalMine);
        }
    }

}