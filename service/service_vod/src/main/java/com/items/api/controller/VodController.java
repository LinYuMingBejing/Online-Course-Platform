package com.items.api.controller;

import com.items.api.commonutils.R;
import com.items.api.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/eduvod/video")
public class VodController {

    @Autowired
    private VodService vodService;

    // 上傳視頻
    @PostMapping("uploadAlyVideo")
    public R uploadVideo(MultipartFile file){
        // 返回上傳視頻id
        // String videoId = vodService.uploadVideo(file);
        return R.ok();
    }


    // 刪除多個影片id
    @DeleteMapping("delete-batch")
    public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList){
        vodService.removeVideos(videoIdList);
        return R.ok();
    }
}
