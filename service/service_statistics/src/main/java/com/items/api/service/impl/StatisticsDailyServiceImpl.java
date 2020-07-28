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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Override
    public Map<String, Object> getShowData(String type, String begin, String end) {
        // 根據條件查詢對應數據
        QueryWrapper<StatisticsDaily> wrapper = new QueryWrapper<>();
        wrapper.between("date_calculated", begin, end);
        wrapper.select("date_calculated", type);
        List<StatisticsDaily> staList = baseMapper.selectList(wrapper);

        List<String> date_calculatedList = new ArrayList<>();
        List<Integer> numDataList = new ArrayList<>();

        for (int i = 0; i < staList.size(); i++) {
            StatisticsDaily daily = staList.get(i);
            date_calculatedList.add(daily.getDateCalculated());

            switch (type){
                case "login_num":
                    numDataList.add(daily.getLoginNum());
                    break;

                case "register_num":
                    numDataList.add(daily.getRegisterNum());
                    break;

                case "video_view_num":
                    numDataList.add(daily.getVideoViewNum());
                    break;

                default:
                    break;
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("date_calculatedList", date_calculatedList);
        map.put("numDatalist", numDataList);
        return map;
    }
}
