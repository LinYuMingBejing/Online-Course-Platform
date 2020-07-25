package com.items.api.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  // 生成有參構造方法
@NoArgsConstructor  //  生成無參構造方法
public class GuliException extends RuntimeException{

    private Integer code; // 狀態碼
    private String msg; //異常信息


}
