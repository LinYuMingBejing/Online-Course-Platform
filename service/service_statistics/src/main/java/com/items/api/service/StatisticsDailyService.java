package com.items.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.items.api.entity.StatisticsDaily;

public interface StatisticsDailyService extends IService<StatisticsDaily> {
    void registerCount(String day);
}
