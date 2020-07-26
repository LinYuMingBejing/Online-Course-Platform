package com.items.api.controller;

import com.items.api.commonutils.R;
import com.items.api.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
}
