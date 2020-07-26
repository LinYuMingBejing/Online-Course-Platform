package com.items.api.entity.frontvo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CourseFrontVo implements Serializable {

    @ApiModelProperty(value = "課程名稱")
    private String title;

    @ApiModelProperty(value = "講師id")
    private String teacherId;

    @ApiModelProperty(value = "一級類別id")
    private String subjectParentId;

    @ApiModelProperty(value = "二級類別id")
    private String subjectId;

    @ApiModelProperty(value = "銷量排序")
    private String buyCCountSort;

    @ApiModelProperty(value = "最新時間排序")
    private String gmtCreateSort;

    @ApiModelProperty(value = "價格排序")
    private String priceSort;

}
