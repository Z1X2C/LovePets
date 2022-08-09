package com.zhangbo.lovepets.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangbo.lovepets.pojo.Adoption;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdoptionMapper extends BaseMapper<Adoption> {
}
