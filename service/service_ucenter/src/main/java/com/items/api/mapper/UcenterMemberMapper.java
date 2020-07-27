package com.items.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.items.api.entity.UcenterMember;

public interface UcenterMemberMapper extends BaseMapper<UcenterMember> {
    // 查詢註冊人數
    Integer countRegisterDay(String day);
}
