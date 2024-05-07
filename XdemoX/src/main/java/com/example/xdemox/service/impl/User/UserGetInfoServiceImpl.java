package com.example.xdemox.service.impl.User;

import com.example.xdemox.context.BaseContext;
import com.example.xdemox.mapper.SkillMapper;
import com.example.xdemox.mapper.UserInfoMapper;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.pojo.entity.Skill;
import com.example.xdemox.pojo.entity.Userinfo;
import com.example.xdemox.pojo.vo.UserInfoVo;
import com.example.xdemox.service.User.UserGetInfoService;
import com.example.xdemox.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserGetInfoServiceImpl implements UserGetInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    TokenUtils tokenUtils;
    @Autowired
    SkillMapper skillMapper;
    @Override
    public Result getinfo() {

        UserInfoVo userInfoVo=new UserInfoVo();
        String stringid =BaseContext.getThreadLocal().toString();
        Integer id= Integer.valueOf(stringid);

        Userinfo userinfo=userInfoMapper.selectById(id);
        BeanUtils.copyProperties(userinfo,userInfoVo);
        userInfoVo.setSkill1(skillMapper.selectById(userinfo.getSkill1()).getKind());
        userInfoVo.setSkill2(skillMapper.selectById(userinfo.getSkill2()).getKind());
        return Result.success(userInfoVo);
    }
}
