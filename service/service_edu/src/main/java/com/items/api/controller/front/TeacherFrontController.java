package com.items.api.controller.front;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.items.api.commonutils.R;
import com.items.api.entity.EduCourse;
import com.items.api.entity.EduTeacher;
import com.items.api.service.EduCourseService;
import com.items.api.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eduservice/teacherfront")
@CrossOrigin
public class TeacherFrontController {

    @Autowired
    private EduTeacherService teacherService;

    @Autowired
    private EduCourseService courseService;

    // 1. 分頁查詢講師
    @PostMapping("getTeacherFrontList/{page}/{limit}")
    public R getTeacherFrontList(@PathVariable long page,
                                 @PathVariable long limit){

        Page<EduTeacher> pageTeacher = new Page<>(page, limit);
        Map<String, Object> map = teacherService.getTeacherFrontList(pageTeacher);

        // 返回分頁所有數據
        return R.ok().data("data", map);
    }

    //  講師詳情功能
    @GetMapping("getTeacherFrontInfo/{teacherId}")
    public R getTeacherFrontInfo(@PathVariable String teacherId){
        // 1. 根據講師id查詢基本資訊
        EduTeacher eduTeacher = teacherService.getById(teacherId);

        // 2. 根據講師ID查詢課程
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id", teacherId);
        List<EduCourse> courseList = courseService.list(wrapper);

        return R.ok().data("teacher", eduTeacher).data("courseList", courseList);
    }
}
