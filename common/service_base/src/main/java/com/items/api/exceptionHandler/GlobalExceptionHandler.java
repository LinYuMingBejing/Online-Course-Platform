package com.items.api.exceptionHandler;


import com.items.api.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 指定出現什麼異常執行這個方法
    @ExceptionHandler(Exception.class)
    @ResponseBody // 返回數據
    public R error(Exception e){
        return R.error().message("執行了全局異常處理....");
    }

    // 特定異常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody // 返回數據
    public R error(ArithmeticException e){
        return R.error().message("執行了ArithmeticException異常處理....");
    }

    @ExceptionHandler(GuliException.class)
    @ResponseBody // 返回數據
    public R error(GuliException e){
        log.error(e.getMessage());
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
