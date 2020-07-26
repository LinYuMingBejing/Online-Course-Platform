package com.items.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.items.api.entity.CrmBanner;

import java.util.List;

public interface CrmBannerService extends IService<CrmBanner> {
    List<CrmBanner> selectAllBanner();
}
