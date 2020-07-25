package com.items.api.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EduVideo implements Serializable {

    private static final long serialVersionUID = 1l;

    @ApiModelProperty(value = "課程類別ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    private String courseId;

    private String chapterId;

    private String title;

    private String videoSourceId;

    private String videoOrigin;

    @ApiModelProperty(value = "創建時間")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新時間")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModify;

}
