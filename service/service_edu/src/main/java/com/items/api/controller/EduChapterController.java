package com.items.api.controller;


import com.items.api.commonutils.R;
import com.items.api.entity.chapter.ChapterVo;
import com.items.api.entity.vo.CourseInfoVo;
import com.items.api.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eduservice/chapter")
public class EduChapterController {

    @Autowired
    private EduChapterService chapterService;

    // 課程大綱
    @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId){
        List<ChapterVo>list = chapterService.getChapterByCourseId(courseId);
        return R.ok().data("allChapterVideo", list);
    }

}
