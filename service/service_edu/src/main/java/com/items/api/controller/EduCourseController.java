package com.items.api.controller;


import com.items.api.commonutils.R;
import com.items.api.entity.vo.CourseInfoVo;
import com.items.api.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    // 添加課程基本信息
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        courseService.saveCourseInfo(courseInfoVo);
        return R.ok();
    }
    // 根據課程查詢基本訊息
    @GetMapping("getCouseInfo/{id}")
    public R getCourseInfo(@PathVariable String courseId){
        CourseInfoVo courseInfoVo = courseService.getCourseInfo(courseId);
        return R.ok().data("courseInfoVo",courseInfoVo);
    }

    // 修改課程資訊
    @PostMapping("updateCousreInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        courseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }
}
