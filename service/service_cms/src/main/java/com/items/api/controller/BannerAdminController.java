package com.items.api.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.items.api.commonutils.R;
import com.items.api.entity.CrmBanner;
import com.items.api.service.CrmBannerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/educms/banneradmin")
@CrossOrigin
public class BannerAdminController {

    @Autowired
    private CrmBannerService bannerService;
    // 分頁查詢banner
    @GetMapping("pageBanner/{page}/{limit}")
    public R pageBanner(@PathVariable long page,
                        @PathVariable long limit){
        Page<CrmBanner> pageBanner = new Page<>(page, limit);
        bannerService.page(pageBanner, null);
        return R.ok().data("items",pageBanner.getRecords()).data("total",pageBanner.getTotal());

    }

    // 添加banner
    @PostMapping("addBanner")
    public R addBanner(@RequestBody CrmBanner crmBanner){
        bannerService.save(crmBanner);
        return R.ok();
    }

    @ApiOperation(value = "獲取Banner")
    @GetMapping("get/{id}")
    public R get(@PathVariable String id){
        CrmBanner banner = bannerService.getById(id);
        return R.ok().data("items",banner);
    }

    @ApiOperation(value = "修改Banner")
    @PutMapping("update")
    public R updateById(@RequestBody CrmBanner banner){
        bannerService.updateById(banner);
        return R.ok();
    }

    @ApiOperation(value = "刪除banner")
    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id){
        bannerService.removeById(id);
        return R.ok();
    }
}
