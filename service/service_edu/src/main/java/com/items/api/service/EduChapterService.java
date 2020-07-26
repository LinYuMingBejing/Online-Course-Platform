package com.items.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.items.api.entity.EduChapter;
import com.items.api.entity.chapter.ChapterVo;

import java.util.List;

public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterByCourseId(String courseId);

    void deleteChapter(String chapterId);

    void removeChapterByCourseId(String courseId);
}
