package com.items.api.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TeacherQuery {

    @ApiModelProperty(value = "教師名稱，模糊查詢")
    private String name;

    @ApiModelProperty(value = "頭銜，1 高級講師 2 首席講師")
    private Integer level;

    @ApiModelProperty(value = "查詢開始時間", example = "2019-12-01")
    private String begin;

    @ApiModelProperty(value = "查詢結束時間", example = "2019-12-01")
    private String end;
}
