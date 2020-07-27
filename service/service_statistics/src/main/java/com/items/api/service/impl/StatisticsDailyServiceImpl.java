package com.items.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.items.api.client.UcenterClient;
import com.items.api.commonutils.R;
import com.items.api.entity.StatisticsDaily;
import com.items.api.mapper.StatisticsDailyMapper;
import com.items.api.service.StatisticsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;


@Service
public class StatisticsDailyServiceImpl extends ServiceImpl<StatisticsDailyMapper, StatisticsDaily> implements StatisticsDailyService {

    @Autowired
    private UcenterClient ucenterClient;


    @Override
    public void registerCount(String day) {

        QueryWrapper<StatisticsDaily> wrapper = new QueryWrapper<>();
        wrapper.eq("date_calculated",day);
        baseMapper.delete(wrapper);

        // 遠程調用
        R registerR = ucenterClient.countRegister(day);
        Integer countRegister = (Integer) registerR.getData().get("countRegister");

        // 獲取數據添加至數據庫當中
        StatisticsDaily statistics = new StatisticsDaily();
        statistics.setRegisterNum(countRegister); // 註冊人數
        statistics.setDateCalculated(day); // 統計日期

        baseMapper.insert(statistics);
    }
}
