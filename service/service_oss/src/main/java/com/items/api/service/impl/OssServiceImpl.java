package com.items.api.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.items.api.service.OssService;
import com.items.api.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFileAvatar(MultipartFile file) {

        // 工具類獲取值
        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_Id;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        try{
            // 創建OSS實例
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 獲取上傳文件輸入流
            InputStream fileInputStream = file.getInputStream();

            String filename = file.getOriginalFilename();

            String uuid = UUID.randomUUID().toString();

            filename = uuid + filename;

            String datePath = new DateTime().toString("yyyy/MM/dd");

            filename = datePath + "/" + filename;


            // 實現上傳
            ossClient.putObject(bucketName, filename, fileInputStream);

            // 關閉 ossClient
            ossClient.shutdown();

            String url = "https://"+bucketName+"."+endpoint+"/"+filename;
            return url;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
