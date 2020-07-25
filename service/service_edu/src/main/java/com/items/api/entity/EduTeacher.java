package com.items.api.entity;


import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


@Accessors(chain = true)
@ApiModel(value = "EduTeacher對象", description = "講師")
@Data
public class EduTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "講師ID")
    @TableId(value = "id", type =  IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "講師姓名")
    private String name;

    @ApiModelProperty(value = "講師簡介")
    private String intro;

    @ApiModelProperty(value = "講師資歷，一句話說明講師")
    private String career;

    @ApiModelProperty(value = "頭銜 1高級講師 2首席講師")
    private Integer level;

    private String avatar;

    private Integer sort;

    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "創建時間")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新時間")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModify;

}
