package com.items.api.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {

    // 設置excel 表頭
    @ExcelProperty("一級分類")
    private String sno;

    @ExcelProperty("二級分類")
    private String sname;
}
