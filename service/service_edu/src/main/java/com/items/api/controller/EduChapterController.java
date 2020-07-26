package com.items.api.controller;


import com.items.api.commonutils.R;
import com.items.api.entity.EduChapter;
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

    // 添加章節
    @PostMapping("addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter){
        chapterService.save(eduChapter);
        return R.ok();
    }
    
    // 根據章節id查詢
    @GetMapping("getChapterInfo/{chapterId}")
    public R getChapterInfo(@PathVariable String chapterId){
        EduChapter eduChapter = chapterService.getById(chapterId);
        return R.ok().data("chapter",eduChapter);
    }

    // 修改章節
    @PostMapping("updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter){
        chapterService.updateById(eduChapter);
        return R.ok();
    }

    // 刪除方法
    @DeleteMapping("{chapterId}")
    public R deleteChapter(@PathVariable String chapterId){
        chapterService.deleteChapter(chapterId);
        return R.ok();
    }

}
