package com.example.xdemox.service.impl.admin;

import com.example.xdemox.mapper.SkillMapper;
import com.example.xdemox.mapper.UserInfoMapper;
import com.example.xdemox.mapper.UserMapper;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.pojo.entity.Userinfo;
import com.example.xdemox.pojo.vo.UserInfoVo;
import com.example.xdemox.service.admin.GetOneMasterServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetOneMasterServerImpl implements GetOneMasterServer {

    @Autowired

    UserInfoMapper userInfoMapper;

    @Autowired
    SkillMapper skillMapper;
    @Override
    public Result getone(Integer id) {
        Userinfo userinfo=userInfoMapper.selectById(id);
        if(userinfo==null){
            return Result.error("没有该用户");
        }
        UserInfoVo userInfoVo=new UserInfoVo();
        BeanUtils.copyProperties(userinfo,userInfoVo);
        String string1 =skillMapper.selectById(userinfo.getSkill1()).getKind();
        userInfoVo.setSkill1(string1);
        log.info("skill1"+string1);
        String string2 =skillMapper.selectById(userinfo.getSkill2()).getKind();
        userInfoVo.setSkill2(string2);
        log.info("skill1"+string2);

        return Result.success(userInfoVo);
    }
}
