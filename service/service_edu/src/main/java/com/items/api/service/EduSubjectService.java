package com.items.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.items.api.entity.EduSubject;
import com.items.api.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EduSubjectService extends IService<EduSubject> {
    // 添加課程分類
    void saveSubject(MultipartFile file, EduSubjectService subjectService);

    List<OneSubject> getAllTwoSubject();
}
