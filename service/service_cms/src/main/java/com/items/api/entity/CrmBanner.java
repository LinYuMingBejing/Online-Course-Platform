package com.items.api.entity;


import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CrmBanner implements Serializable {
    private static final long serialVersionUID = 1l;

    @ApiModelProperty(value = "課程類別ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "標題")
    private String title;

    @ApiModelProperty(value = "圖片地址")
    private String imageUrl;

    @ApiModelProperty(value = "鏈接地址")
    private String linkUrl;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "邏輯刪除")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "創建時間")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新時間")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModify;
}
