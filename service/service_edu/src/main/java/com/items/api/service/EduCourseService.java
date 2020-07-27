package com.items.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.items.api.entity.EduCourse;
import com.items.api.entity.frontvo.CourseFrontVo;
import com.items.api.entity.frontvo.CourseWebVo;
import com.items.api.entity.vo.CourseInfoVo;
import com.items.api.entity.vo.CoursePublishVo;

import java.util.List;
import java.util.Map;

public interface EduCourseService extends IService<EduCourse> {

    // 添加課程基本信息
    void saveCourseInfo(CourseInfoVo courseInfoVo);

    // 根據課程id查詢課程基本資訊
    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    void removeCourse(String courseId);

    Map<String, Object> getCourseFrontList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo);

    CourseWebVo getBaseCourseInfo(String courseId);
}
