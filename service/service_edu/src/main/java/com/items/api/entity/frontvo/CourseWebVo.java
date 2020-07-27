package com.items.api.entity.frontvo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseWebVo {

    private String id;

    @ApiModelProperty(value = "課程標題")
    private String title;

    @ApiModelProperty(value = "課程銷售價格")
    private BigDecimal price;

    @ApiModelProperty(value = "總課時")
    private Integer lessonNum;

    @ApiModelProperty(value = "課程封面圖片路徑")
    private String cover;

    @ApiModelProperty(value = "銷售數量")
    private Long buyCount;

    @ApiModelProperty(value = "瀏覽數量")
    private Long viewCount;

    @ApiModelProperty(value = "課程簡介")
    private String description;

    @ApiModelProperty(value = "講師ID")
    private String teacherId;

    @ApiModelProperty(value = "講師姓名")
    private String teacherName;

    @ApiModelProperty(value = "講師經歷")
    private String intro;

    @ApiModelProperty(value = "講師頭貼")
    private String avatar;

    @ApiModelProperty(value = "課程一級類別ID")
    private String subjectLevelOneId;

    @ApiModelProperty(value = "課程一級類別")
    private String subjectLevelOne;

    @ApiModelProperty(value = "類別二級名稱")
    private String subjectLevelTwoId;

    @ApiModelProperty(value = "類別二級名稱")
    private String subjectLevelTwo;

}
