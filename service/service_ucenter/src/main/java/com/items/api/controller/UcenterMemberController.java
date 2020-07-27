package com.items.api.controller;


import com.items.api.commonutils.JwtUtils;
import com.items.api.commonutils.R;
import com.items.api.entity.UcenterMember;
import com.items.api.entity.vo.RegisterVo;
import com.items.api.service.UcenterMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/educenter/member")
@CrossOrigin
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService memberService;

    // 登入
    @PostMapping("login")
    public R loginUser(@RequestBody UcenterMember member){
        // 調用service方法實現登入
        // 返回token值，使用jwt生成
        String token = memberService.login(member);

        return R.ok().data("token",token);
    }

    // 註冊
    @PostMapping("register")
    public R registerUser(@RequestBody RegisterVo registerVo){
        memberService.register(registerVo);
        return R.ok();
    }

    // 根據token 獲取用戶資訊
    @GetMapping("getMemberInfo")
    public R getMemberInfo(HttpServletRequest request){
        // 調用jwt工具方法，獲取頭資訊與用戶ID
        String memberid = JwtUtils.getMemberIdByJwtToken(request);
        // 根據用戶id獲取用戶資訊
        UcenterMember member = memberService.getById(memberid);
        return R.ok().data("userInfo",member);
    }

    // 查詢某一天註冊人數
    @GetMapping("countRegister/{day}")
    public R countRegister(@PathVariable String day){
        Integer count = memberService.countRegisterDay(day);
        return R.ok().data("countRegister",count);
    }



}
