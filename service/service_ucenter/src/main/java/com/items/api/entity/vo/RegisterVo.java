package com.items.api.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterVo {

    @ApiModelProperty(value = "暱稱")
    private String nickname;

    @ApiModelProperty(value = "手機號")
    private String mobile;

    @ApiModelProperty(value = "密碼")
    private String password;

    @ApiModelProperty(value = "驗證碼")
    private String code;
}
