package com.zhangbo.lovepets.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangbo.lovepets.mapper.AdminMapper;
import com.zhangbo.lovepets.pojo.Admin;
import com.zhangbo.lovepets.service.AdminService;
import com.zhangbo.lovepets.until.Result;
import com.zhangbo.lovepets.until.Status;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Mapper
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @Override
    public Result login(Admin admin) {
      Admin admin1= adminMapper.selectOne(new LambdaQueryWrapper<Admin>().eq(Admin::getAdminName,admin.getAdminName())
               .or().eq(Admin::getAdminId,admin.getAdminId()));
      if (admin1!=null){
         return Result.resultFactory(Status.LOGIN_SUCCESS,admin1);
      }
        return Result.resultFactory(Status.LOGIN_FAIL);
    }
}
