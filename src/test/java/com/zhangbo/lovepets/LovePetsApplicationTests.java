package com.zhangbo.lovepets;

import com.zhangbo.lovepets.pojo.Admin;
import com.zhangbo.lovepets.pojo.User;
import com.zhangbo.lovepets.service.AdminService;
import com.zhangbo.lovepets.service.NavigationService;
import com.zhangbo.lovepets.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LovePetsApplicationTests {
    @Autowired
    private UserService userServices;
    @Test
    void test() {
//        User user=new User();
//        user.setUserId("1553575855620157441");
//        user.setUserName("zhangsan");
//        user.setUserPhone("17321952292");
//        user.setUserAdd("成都");
//        user.setPassword("zhangbo123");
//        user.setEmail("2466258400@qq.com");
//        user.setSign("学到死");
//        userServices.updateById(user);
    }
}
