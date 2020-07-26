package com.items.api.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UcenterMember對象", description = "會員表")
public class UcenterMember implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "會員id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "openid")
    private String openid;

    @ApiModelProperty(value = "手機號")
    private String mobile;

    @ApiModelProperty(value = "密碼")
    private String password;

    @ApiModelProperty(value = "暱稱")
    private String nickname;

    @ApiModelProperty(value = "性別 1女, 2男")
    private Integer sex;

    @ApiModelProperty(value = "用戶頭像")
    private String avatar;

    @ApiModelProperty(value = "用戶簽名")
    private String sign;

    @ApiModelProperty(value = "是否被禁用")
    private Boolean isDisabled;

    @ApiModelProperty(value = "是否被刪除")
    private Boolean isDeleted;


    @ApiModelProperty(value = "創建時間")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新時間")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModify;


}
