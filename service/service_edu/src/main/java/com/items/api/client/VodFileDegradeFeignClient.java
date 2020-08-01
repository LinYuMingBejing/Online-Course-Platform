package com.items.api.client;

import com.items.api.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VodFileDegradeFeignClient implements VodClient{
    // 出錯後執行
    @Override
    public R removeVideo(String id) {
        return R.error().message("影片刪除失敗");
    }

    @Override
    public R deleteBatch(List<String> videoIdList) {
        return R.error().message("影片刪除失敗");
    }
}
