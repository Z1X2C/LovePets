package com.zhangbo.lovepets.controller;

import com.zhangbo.lovepets.pojo.Navigation;
import com.zhangbo.lovepets.service.NavigationService;
import com.zhangbo.lovepets.until.Result;
import com.zhangbo.lovepets.until.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@CrossOrigin
@RestController
@RequestMapping("/navigation")
public class NavigationController {
    //查询所有导航
    @Autowired
   private NavigationService service;
    @Autowired
   private RedisTemplate redisTemplate;
    @GetMapping
    public Result findAll() {
        List<Navigation> navigation= service.list();
        String key="navigation";
        //存入redis
        redisTemplate.opsForList().leftPush(key,navigation);
        return Result.resultFactory(Status.STATUS,navigation);
    }
}
