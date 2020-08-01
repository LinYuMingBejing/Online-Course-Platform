package com.items.api.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VodService {
    // 上傳影片
    String uploadVideo(MultipartFile file);

    // 刪除影片
    void removeVideos(List videoIdList);
}
