package com.items.api.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {

    public static void main(String[] args) {
        // 實現Excel 寫的操作
        // 1. 設置寫入文件夾地址和excel文件名稱
        String filename = "/Users/linyuming/Documents/Practice/demo3.xlsx";

        // 2. 調用easyexcel方法實現寫操作
        EasyExcel.write(filename, DemoData.class).sheet("學生列表").doWrite(getData());

    }

    private static List<DemoData> getData(){
        List<DemoData> list = new ArrayList<>();
        DemoData data = new DemoData();

        data.setSno("後端");
        data.setSname("golang");
        list.add(data);



        return list;
    }
}
