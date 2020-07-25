package com.items.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.items.api.entity.EduCourse;
import com.items.api.entity.vo.CourseInfoVo;

import java.util.List;

public interface EduCourseService extends IService<EduCourse> {

    // 添加課程基本信息
    void saveCourseInfo(CourseInfoVo courseInfoVo);

    // 根據課程id查詢課程基本資訊
    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);
}
