package com.items.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.items.api.commonutils.JwtUtils;
import com.items.api.commonutils.MD5;
import com.items.api.entity.UcenterMember;
import com.items.api.entity.vo.RegisterVo;
import com.items.api.exceptionHandler.GuliException;
import com.items.api.mapper.UcenterMemberMapper;
import com.items.api.service.UcenterMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    // 登入方法
    @Override
    public String login(UcenterMember member) {

        // 獲取登入手機號和密碼
        String mobile = member.getMobile();
        String password = member.getPassword();

        // 手機號和密碼為空判斷
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
            throw new GuliException(20001,"登入失敗");
        }

        // 判斷手機號是否正確
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        UcenterMember mobileMember = baseMapper.selectOne(wrapper);

        // 判斷查詢對象是否為空
        if(mobileMember==null){
            throw new GuliException(20001, "登入失敗");
        }

        // 判斷密碼
        // 密碼加密 : MD5

        if(!MD5.encrypt(password).equals(mobileMember.getPassword())){
            throw new GuliException(20001,"登入失敗");
        }

        //是否被禁用
        if(mobileMember.getIsDisabled()){
            throw new GuliException(20001,"登入失敗");
        }

        // 登入成功
        // 生成token字符串，使用jwt工具類
        String jwtToken = JwtUtils.getJwtToken(mobileMember.getId(), mobileMember.getNickname());

        return jwtToken;
    }

    @Override
    public void register(RegisterVo registerVo) {
        // 獲取註冊數據
        String code = registerVo.getCode();
        String mobile = registerVo.getMobile();
        String nickname = registerVo.getNickname();
        String password = registerVo.getPassword();

        // 非空判斷
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)
            || StringUtils.isEmpty(code) || StringUtils.isEmpty(nickname)){
            throw new GuliException(20001,"註冊失敗");
        }

        // 判斷驗證碼
        //String redisCode = redisTemplate.opsForValue().get(mobile);
        //if(!code.equals(redisCode)){
        //    throw new GuliException(20001,"驗證碼無效");
        //}

        // 判斷手機號是否重複
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        Integer count = baseMapper.selectCount(wrapper);
        if(count > 0 ){
            throw new GuliException(20001,"手機號重複");
        }

        // 數據添加至數據庫中
        UcenterMember member = new UcenterMember();
        member.setMobile(mobile);
        member.setNickname(nickname);
        member.setPassword(MD5.encrypt(password));
        member.setIsDisabled(false);
        baseMapper.insert(member);

    }
}
