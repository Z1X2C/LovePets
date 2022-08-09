package com.zhangbo.lovepets.controller;


import com.zhangbo.lovepets.pojo.Admin;
import com.zhangbo.lovepets.service.AdminService;
import com.zhangbo.lovepets.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(("/admins"))
public class AdminController {
    @Autowired
    private AdminService adminService;
    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public Result admin_Login(@RequestBody Admin admin){
        return adminService.login(admin);
    }
}
