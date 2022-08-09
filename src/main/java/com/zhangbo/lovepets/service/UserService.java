package com.zhangbo.lovepets.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangbo.lovepets.pojo.User;
import com.zhangbo.lovepets.until.Result;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User> {
    Result User_register(User user);

    Result login(User user);

    IPage<User> getPage(int current_page, int page_size, User user);

    Result findByid(String user_id);

    User loadUserByUsername(String username) throws UsernameNotFoundException;
}
