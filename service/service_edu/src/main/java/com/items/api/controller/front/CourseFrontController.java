package com.items.api.controller.front;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.items.api.commonutils.R;
import com.items.api.entity.EduCourse;
import com.items.api.entity.chapter.ChapterVo;
import com.items.api.entity.frontvo.CourseFrontVo;
import com.items.api.entity.frontvo.CourseWebVo;
import com.items.api.service.EduChapterService;
import com.items.api.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eduservice/coursefront")
@CrossOrigin
public class CourseFrontController {

    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduChapterService chapterService;

    // 條件查詢帶分頁查詢課程
    @PostMapping("getFrontCourseList/{page}/{limit}")
    public R getFrontCourseList(@PathVariable long page,
                                @PathVariable long limit,
                                @RequestBody(required = false) CourseFrontVo courseFrontVo){

        Page<EduCourse> pageCourse = new Page<>(page, limit);
        Map<String, Object> map = courseService.getCourseFrontList(pageCourse, courseFrontVo);

        return R.ok().data("data", map);
    }

    // 課程詳情方法
    @GetMapping("getFrontCourseInfo/{courseId}")
    public R getFrontCourseInfo(@PathVariable String courseId){
        // 根據課程id, 編寫SQL語句查詢課程資訊
        CourseWebVo courseWebVo = courseService.getBaseCourseInfo(courseId);

        // 根據課程id，查詢章節與小節
        List<ChapterVo> courseList = chapterService.getChapterByCourseId(courseId);
        return R.ok().data("courseWebVo", courseWebVo).data("courseList",courseList);

    }


}
