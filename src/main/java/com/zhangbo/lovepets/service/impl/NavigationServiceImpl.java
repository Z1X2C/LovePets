package com.zhangbo.lovepets.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangbo.lovepets.mapper.NavigationMapper;
import com.zhangbo.lovepets.pojo.Navigation;
import com.zhangbo.lovepets.service.NavigationService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Mapper
@Transactional
public class NavigationServiceImpl extends ServiceImpl<NavigationMapper, Navigation> implements NavigationService {
}
