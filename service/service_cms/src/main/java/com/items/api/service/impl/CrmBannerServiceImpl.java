package com.items.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.items.api.entity.CrmBanner;
import com.items.api.mapper.CrmBannerMapper;
import com.items.api.service.CrmBannerService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService{

    // 查詢所有banner
    @Cacheable(key = "'selectIndexList'", value = "banner")
    @Override
    public List<CrmBanner> selectAllBanner() {
        // 根據id進行降冪排列，顯示前兩條數據
        QueryWrapper<CrmBanner> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        // last方法，拼接sql語句
        wrapper.last("limit 2");

        List<CrmBanner> list = baseMapper.selectList(null);
        return list;
    }
}

