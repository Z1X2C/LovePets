package com.zhangbo.lovepets.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangbo.lovepets.pojo.Pet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PetMapper extends BaseMapper<Pet> {
}
