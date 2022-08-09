package com.zhangbo.lovepets.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangbo.lovepets.mapper.UserMapper;
import com.zhangbo.lovepets.pojo.User;
import com.zhangbo.lovepets.service.UserService;
import com.zhangbo.lovepets.until.MD5;
import com.zhangbo.lovepets.until.Result;
import com.zhangbo.lovepets.until.Status;
import org.apache.ibatis.annotations.Mapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Mapper
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 用户注册
     */
    @Override
    public Result User_register(User user) {
        if (check_name(user)) {//检查用户名是否已经注册
            if (check_phone(user)) {//检查电话是否已经注册
                if (check_email(user)) {//检查邮箱是否已经注册
                    user.setPassword(MD5.convertMD5(user.getPassword()));
                    save(user);
                    return Result.resultFactory(Status.REGISTER_SUCCESS, user);
                } else {
                    return Result.resultFactory(Status.REGISTER_FAIL_EMAIL_HAS, null);
                }
            } else {
                return Result.resultFactory(Status.REGISTER_FAIL_HAS, null);
            }
        } else {
            return Result.resultFactory(Status.REGISTER_FAIL_NAME, null);
        }
    }

    /**
     * 用户登录
     */
    @Override
    public Result login(User user) {
        User user1 = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserPhone, user.getUserName())
                .or().eq(User::getEmail, user.getUserName())
                .or().eq(User::getUserName, user.getUserName()));
        if (user1 != null) {
            if (user1.getPassword().equals(MD5.convertMD5(user.getPassword()))) {
                //将用户信息存入Redis
                String key = "user:" + user1.getUserId();
                redisTemplate.opsForValue().set(key, user1, 60, TimeUnit.MINUTES);
                return Result.resultFactory(Status.LOGIN_SUCCESS, user1.getUserId());
            } else {
                return Result.resultFactory(Status.LOGIN_FAIL);
            }
        } else {
            return Result.resultFactory(Status.LOGIN_FAIL);
        }
    }

    /**
     * 分页查询
     *
     * @param current_page
     * @param page_size
     * @param user
     * @return
     */
    @Override
    public IPage<User> getPage(int current_page, int page_size, User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(user.getUserName()), User::getUserName, user.getUserName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(user.getUserPhone()), User::getUserPhone, user.getUserPhone());
        lambdaQueryWrapper.like(Strings.isNotEmpty(user.getEmail()), User::getEmail, user.getEmail());
        IPage page = new Page<>(current_page, page_size);
        return userMapper.selectPage(page, lambdaQueryWrapper);
    }

    /**
     * 根据用户id查询用户
     *
     * @param user_id
     * @return
     */
    @Override
    public Result findByid(String user_id) {
        //首先通过redis查询
        User user = (User) redisTemplate.opsForValue().get(user_id);
        if (user != null) {
            return Result.resultFactory(Status.STATUS, user);
        } else {
            //到数据库查询
            user = getById(user_id);
            if (user != null) {
                //将用户信息存入Redis
                long key = user.getUserId();
                redisTemplate.opsForValue().set("user:" + key, user, 60, TimeUnit.MINUTES);
                return Result.resultFactory(Status.STATUS, user);
            } else {
                return Result.resultFactory(Status.USER_DOEST_NOT);
            }
        }
    }


    /**
     * 检查用名是否存在
     */
    public boolean check_name(User user) {
        if (getOne(new QueryWrapper<User>().eq("user_name", user.getUserName())) != null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 检查用户手机是否存在
     */
    public boolean check_phone(User user) {
        if (getOne(new QueryWrapper<User>().eq("user_phone", user.getUserPhone())) != null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 检查用户邮箱是否存在
     */
    public boolean check_email(User user) {
        if (getOne(new QueryWrapper<User>().eq("email", user.getEmail())) != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        lambdaQueryWrapper.eq(User::getUserName,username);
        User user=userMapper.selectOne(lambdaQueryWrapper);
        return null;
    }
}
