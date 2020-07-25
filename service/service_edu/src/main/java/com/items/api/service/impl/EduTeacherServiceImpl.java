package com.items.api.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.items.api.entity.EduTeacher;
import com.items.api.mapper.EduTeacherMapper;
import com.items.api.service.EduTeacherService;
import org.springframework.stereotype.Service;

@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService{
}
