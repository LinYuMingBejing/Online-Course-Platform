package com.items.api.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 當項目啟動，spring接口，spring加載之後，執行接口一個方法
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    // 讀取配置文件內容
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.file.keyId}")
    private String keyId;

    @Value("${aliyun.oss.file.keysecret}")
    private String keySecret;

    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;

    // 定義公開靜態常量
    public static String END_POINT;

    public static String ACCESS_KEY_Id;

    public static String ACCESS_KEY_SECRET;

    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_Id = keyId;
        ACCESS_KEY_SECRET = keySecret;
        BUCKET_NAME = bucketName;


    }
}
