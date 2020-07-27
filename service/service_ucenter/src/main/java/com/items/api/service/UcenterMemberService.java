package com.items.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.items.api.entity.UcenterMember;
import com.items.api.entity.vo.RegisterVo;

public interface UcenterMemberService extends IService<UcenterMember> {

    // 登入方法
    String login(UcenterMember member);

    // 註冊方法
    void register(RegisterVo registerVo);

    // 查詢註冊人數
    Integer countRegisterDay(String day);
}
