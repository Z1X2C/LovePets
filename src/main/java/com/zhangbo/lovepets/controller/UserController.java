package com.zhangbo.lovepets.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhangbo.lovepets.pojo.User;
import com.zhangbo.lovepets.service.UserService;
import com.zhangbo.lovepets.until.Result;
import com.zhangbo.lovepets.until.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping
    public Result User_register(@RequestBody User user){
        return userService.User_register(user);
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Result User_Login( User user){
        System.out.println(user);
        return userService.login(user);
    }

    /**
     * 根据用户id查询
     * @param user_id
     * @return
     */
    @GetMapping("{user_id}")
    public Result findById(@PathVariable String  user_id){
        return userService.findByid(user_id);
    }

    /**
     * 所有用户信息查询
     * @param current_page
     * @param page_size
     * @param user
     * @return
     */
    @GetMapping("{current_page}/{page_size}")
    public Result findAll(@PathVariable int current_page,@PathVariable int page_size, User user){
        System.out.println(current_page+"|"+page_size+"|"+user);
        IPage<User> userIPage=userService.getPage(current_page,page_size,user);
        if (current_page>userIPage.getCurrent()){
          userIPage=userService.getPage((int) userIPage.getCurrent(),page_size,user);
        }
        return Result.resultFactory(Status.STATUS,userIPage);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
   @PutMapping
    public Result Modify_user_info(@RequestBody User user){
      boolean flag=userService.updateById(user);
       if (flag){
           return Result.resultFactory(Status.MODIFY_INFO_SUCCESS);
       }else {
           return Result.resultFactory(Status.MODIFY_INFO_FAIL);
       }
   }

    /**
     * 用户删除
     * @param user_id
     * @return
     */
   @DeleteMapping("{user_id}")
    public Result DeleteUser(@PathVariable String user_id){
     Boolean flag= userService.removeById(user_id);
       if (flag){
           return Result.resultFactory(Status.DELETE_SUCCESS);
       }else {
           return Result.resultFactory(Status.DELETE_FAIL);
       }
   }
}
