package com.items.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.items.api.commonutils.R;
import com.items.api.entity.EduTeacher;
import com.items.api.entity.vo.TeacherQuery;
import com.items.api.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("講師列表")
@RestController
//@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    // 查看所有數據
    @ApiOperation(value = "所有講師列表")
    @GetMapping("/findAll")
    public R findAllTeacher(){
        // 調用service的方法，實現查詢所有的操作
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("data",list);
    }

    @ApiOperation(value = "邏輯刪除講師")
    @DeleteMapping("/delete/{id}")
    public R removeById(
            @ApiParam(name="id",value="講師ID", required = true)
            @PathVariable String id){
        boolean flag = teacherService.removeById(id);
        if(flag){
            return R.ok();
        }else{
            return R.error();
        }
    }

    // 分頁查詢講師方法
    @GetMapping("/pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current,
                             @PathVariable long limit){

        // 創建page對象
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);
        // 調用方法實現分頁
        // 調用方法，底層封裝，把分頁所有數據風撞到pageTeacher對象裡面
        teacherService.page(pageTeacher, null);

        long total = pageTeacher.getTotal();//總記錄數
        List<EduTeacher> records = pageTeacher.getRecords();

        return R.ok().data("total", total).data("rows",records);
    }

    // 4. 條件查詢帶分頁
    @PostMapping("/pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,
                                  @PathVariable long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery){
        // 創建page對象
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);

        // 構建條件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

        // 多條件組合查詢
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        //調用方法實現條件分頁
        teacherService.page(pageTeacher, wrapper);
        // 判斷條件值是否為空
        if(!StringUtils.isEmpty(name)){
            // 構建條件
            wrapper.like("name",name);
        }

        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }

        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }

        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create",end);
        }


        long total = pageTeacher.getTotal();//總記錄數
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total", total).data("rows",records);

    }

    // 添加講師接口
    @PostMapping("/addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = teacherService.save(eduTeacher);
        if (save){
            return R.ok();
        }else{
            return R.error();
        }
    }

    // 根據講師ID進行查詢
    @GetMapping("/getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        EduTeacher eduTeacher = teacherService.getById(id);
        return R.ok().data("teacher",eduTeacher);
    }

    // 講師修改功能
    @PostMapping("/updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean b = teacherService.updateById(eduTeacher);
        if (b){
            return R.ok();
        }else{
            return R.error();
        }
    }
}
