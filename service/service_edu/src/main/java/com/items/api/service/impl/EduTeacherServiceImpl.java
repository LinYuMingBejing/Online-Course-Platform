package com.items.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.items.api.entity.EduTeacher;
import com.items.api.mapper.EduTeacherMapper;
import com.items.api.service.EduTeacherService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService{

    // 1. 分頁查詢 講師
    @Override
    public Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher) {
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        //把分頁數據封裝至pageTeacher對象
        baseMapper.selectPage(pageTeacher, wrapper);

        List<EduTeacher> records = pageTeacher.getRecords();
        long current = pageTeacher.getCurrent();
        long total = pageTeacher.getTotal();
        long size = pageTeacher.getSize();
        long pages = pageTeacher.getPages();

        boolean hasNext = pageTeacher.hasNext();
        boolean hasPrevious = pageTeacher.hasPrevious();

        // 獲取分頁數據
        Map<String , Object> map = new HashMap<>();
        map.put("records", records);
        map.put("current", current);
        map.put("total", total);
        map.put("size", size);
        map.put("pages", pages);
        map.put("hasNext", hasNext);
        map.put("hasPrevious", hasPrevious);
        return map;
    }
}
