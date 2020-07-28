package com.items.api.controller;


import com.items.api.commonutils.R;
import com.items.api.service.StatisticsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/staservice/sta")
@CrossOrigin
public class StatisticsDailyController {

    @Autowired
    private StatisticsDailyService staService;

    // 統計某天註冊人數
    @PostMapping("registerCount/{day}")
    public R registerCount(@PathVariable String day){
        staService.registerCount(day);
        return R.ok();
    }

    // 圖表顯示，返回兩部分數據
    @GetMapping("showData/{type}/{begin}/{end}")
    public R showData(@PathVariable String type, @PathVariable String begin,
                      @PathVariable String end){
        Map<String, Object> map = staService .getShowData(type, begin, end);
        return R.ok().data("data",map);
    }


}
