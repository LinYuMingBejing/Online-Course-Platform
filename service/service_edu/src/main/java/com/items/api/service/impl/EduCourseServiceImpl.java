package com.items.api.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.items.api.entity.EduCourse;
import com.items.api.entity.EduCourseDescription;
import com.items.api.entity.vo.CourseInfoVo;
import com.items.api.entity.vo.CoursePublishVo;
import com.items.api.exceptionHandler.GuliException;
import com.items.api.mapper.EduCourseMapper;
import com.items.api.service.EduChapterService;
import com.items.api.service.EduCourseDescriptionService;
import com.items.api.service.EduCourseService;
import com.items.api.service.EduVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    @Autowired
    private EduChapterService eduChapterService;

    @Autowired
    private EduVideoService eduVideoService;

    //  添加課程基本信息方法
    @Override
    public void saveCourseInfo(CourseInfoVo courseInfoVo) {

        // 1. 向課程表添加課程基本訊息
        // courseInfoVo 轉換為 eduCourse對象
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if(insert<=0){
            // 添加失敗
            throw new GuliException(20001,"添加課程訊息失敗");
        }

        String cid = eduCourse.getId();
        // 2. 向課程簡介表添加課程簡介
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescription.setId(cid);
        courseDescriptionService.save(courseDescription);
    }

    // 根據課程id查詢課程基本信息
    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        // 1. 查詢課程表
        EduCourse eduCourse = baseMapper.selectById(courseId);
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        BeanUtils.copyProperties(eduCourse, courseInfoVo);
        // 2. 查詢描述表
        EduCourseDescription courseDescription = courseDescriptionService.getById(courseId);
        courseInfoVo.setDescription(courseDescription.getDescription());
        return courseInfoVo;
    }

    // 修改課程資訊
    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        // 1. 修改課程表
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        int update = baseMapper.updateById(eduCourse);
        if(update == 0 ){
            throw new GuliException(20001,"修改課程訊息失敗");
        }

        // 2. 修改描述表
        EduCourseDescription description = new EduCourseDescription();
        description.setId(courseInfoVo.getId());
        description.setDescription(courseInfoVo.getDescription());
        courseDescriptionService.updateById(description);
    }

    // 根據課程id查詢課程確認訊息
    @Override
    public CoursePublishVo publishCourseInfo(String id) {
        CoursePublishVo publishCourseInfo = baseMapper.getPublishCourseInfo(id);
        return publishCourseInfo;
    }

    // 刪除課程
    @Override
    public void removeCourse(String courseId) {
        // 1. 根據課程ID，刪除小節
        eduVideoService.removeVideoByCourseId(courseId);
        // 2. 根據課程ID刪除章節
        eduChapterService.removeChapterByCourseId(courseId);
        // 3. 根據課程id刪除描述
        courseDescriptionService.removeById(courseId);
        // 4. 根據課程id刪除課程本身
        int reuslt = baseMapper.deleteById(courseId);
        if(reuslt==0){
            throw new GuliException(20001,"刪除失敗");
        }
    }
}
