package com.zhaowb.boot.backstage.controller;

import com.zhaowb.boot.backstage.entity.User;
import com.zhaowb.boot.backstage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb [308539393@qq.com]
 * @date 2018/12/6 17:48
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findUserByUserName")
    public User findUserByUserName(String username){
        return userService.findUserByUserName(username);
    }

    /**
     * 查询所有未删除用户
     * @return List<User>
     */
    @RequestMapping("/selectAllUsers")
    @ResponseBody
    public List<User> selectAllUsers(){
        return userService.selectAllUsers();
    }
}
