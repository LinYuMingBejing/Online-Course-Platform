package com.items.api.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@ApiModel(value = "EduCourse對象", description = "課程科目")
public class EduCourse implements Serializable {

    private static final long serialVersionUID = 1l;

    @ApiModelProperty(value = "課程類別ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "講師名稱")
    private Integer teacherId;

    @ApiModelProperty(value = "課程ID")
    private String subjectId;

    @ApiModelProperty(value = "排序字段")
    private String subjectParentId;

    @ApiModelProperty(value = "排序字段")
    private String title;

    @ApiModelProperty(value = "課程價格")
    private Integer price;

    @ApiModelProperty(value = "總課時")
    private Integer lessonNum;

    @ApiModelProperty(value = "課程封面圖片路徑")
    private String cover;

    @ApiModelProperty(value = "銷售數量")
    private Long buyCount;

    @ApiModelProperty(value = "樂觀鎖")
    private Long version;

    @ApiModelProperty(value = "課程狀態")
    private String status;

    @ApiModelProperty(value = "邏輯刪除")
    private Integer isDeleted;

    @ApiModelProperty(value = "創建時間")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新時間")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModify;
}
