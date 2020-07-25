package com.items.api.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    // 上傳頭像至OSS
    String uploadFileAvatar(MultipartFile file);
}
