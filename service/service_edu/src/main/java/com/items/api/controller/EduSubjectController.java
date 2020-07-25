package com.items.api.controller;

import com.items.api.commonutils.R;
import com.items.api.entity.subject.OneSubject;
import com.items.api.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    // 添加課程分類
    // 獲取上傳文件，讀取文件內容
    @PostMapping("/addSubject")
    public R addSubject(MultipartFile file){
        subjectService.saveSubject(file, subjectService);
        return R.ok();
    }

    // 課程分類列表 (樹形)
    @GetMapping("getAllSubject")
    public R getAllSubject(){
        List<OneSubject> list = subjectService.getAllTwoSubject();
        return R.ok().data("list",list);
    }
}
