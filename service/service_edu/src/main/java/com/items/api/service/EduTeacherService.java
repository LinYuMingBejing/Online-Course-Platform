package com.items.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.items.api.entity.EduTeacher;

import java.util.Map;


public interface EduTeacherService extends IService<EduTeacher> {
    Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher);
}
