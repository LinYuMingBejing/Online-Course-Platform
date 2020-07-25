package com.items.api.entity.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value = "課程基本資訊", description = "表單對象")
@Data
public class CourseInfoVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "課程ID")
    private String id;

    @ApiModelProperty(value = "課程講師ID")
    private String subjectId;

    @ApiModelProperty(value = "課程標題")
    private String title;

    @ApiModelProperty(value = "課程銷售價格")
    private Integer price;

    @ApiModelProperty(value = "總課時")
    private Integer lessonNum;

    @ApiModelProperty(value = "課程封面圖片路徑")
    private String cover;

    @ApiModelProperty(value = "課程簡介")
    private String description;
}
