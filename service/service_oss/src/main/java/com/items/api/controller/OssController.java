package com.items.api.controller;

import com.items.api.commonutils.R;
import com.items.api.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    // 上傳頭像方法
    @PostMapping
    public R uploadOssFile(MultipartFile file){
        // 獲取上傳文件
        // 返回上傳oss的路徑
        String url = ossService.uploadFileAvatar(file);

        return R.ok().data("url",url);
    }
}
