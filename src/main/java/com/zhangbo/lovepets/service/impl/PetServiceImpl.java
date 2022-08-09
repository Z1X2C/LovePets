package com.zhangbo.lovepets.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangbo.lovepets.mapper.PetMapper;
import com.zhangbo.lovepets.pojo.Pet;
import com.zhangbo.lovepets.service.PetService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Mapper
@Transactional
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet> implements PetService {
}
