package com.items.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.items.api.entity.EduCourse;
import com.items.api.entity.frontvo.CourseWebVo;
import com.items.api.entity.vo.CoursePublishVo;

public interface EduCourseMapper extends BaseMapper<EduCourse> {
    public CoursePublishVo getPublishCourseInfo(String courseId);

    CourseWebVo getBaseCourseInfo(String courseId);
}
