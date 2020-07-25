package com.items.api.service;

import com.items.api.entity.chapter.ChapterVo;

import java.util.List;

public interface EduChapterService {

    List<ChapterVo> getChapterByCourseId(String courseId);
}
