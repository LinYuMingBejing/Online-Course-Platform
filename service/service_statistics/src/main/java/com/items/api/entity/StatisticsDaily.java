package com.items.api.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class StatisticsDaily {

    @ApiModelProperty(value = "主鍵")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "統計日期")
    private String dateCalculated;

    @ApiModelProperty(value = "註冊人數")
    private Integer registerNum;

    @ApiModelProperty(value = "登入人數")
    private Integer loginNum;

    @ApiModelProperty(value = "影片瀏覽量")
    private Integer videoViewNum;

    @ApiModelProperty(value = "創建時間")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新時間")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModify;
}
