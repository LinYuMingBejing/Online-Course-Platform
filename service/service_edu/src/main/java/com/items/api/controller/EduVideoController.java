package com.items.api.controller;

import com.items.api.client.VodClient;
import com.items.api.commonutils.R;
import com.items.api.entity.EduVideo;
import com.items.api.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class EduVideoController {

    @Autowired
    private EduVideoService videoService;

    @Autowired
    private VodClient vodClient;

    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        videoService.save(eduVideo);
        return R.ok();
    }

    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id){
        // 根據小節獲取影片id，調用方法實現影片刪除
        EduVideo eduVideo = videoService.getById(id);
        String videoSourceId = eduVideo.getVideoSourceId();
        if (StringUtils.isEmpty(videoSourceId)){
            // 根據影片id，調用實現影片刪除
            vodClient.removeVideo(videoSourceId);
        }
        // 刪除小節
        videoService.removeById(id);
        return R.ok();
    }





}
