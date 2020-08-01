package com.items.api.service.Impl;


import com.items.api.service.VodService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class VodServiceImpl implements VodService {
    @Override
    public String uploadVideo(MultipartFile file) {
        return null;
    }

    // 刪除影片
    @Override
    public void removeVideos(List videoIdList) {

    }
}
