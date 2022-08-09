package com.zhangbo.lovepets.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangbo.lovepets.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
