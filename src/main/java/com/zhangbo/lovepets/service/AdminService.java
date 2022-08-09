package com.zhangbo.lovepets.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangbo.lovepets.pojo.Admin;
import com.zhangbo.lovepets.pojo.User;
import com.zhangbo.lovepets.until.Result;

public interface AdminService extends IService<Admin> {
    Result login(Admin admin);
}
