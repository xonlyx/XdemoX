package com.example.xdemox.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xdemox.pojo.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<Userinfo> {
}
