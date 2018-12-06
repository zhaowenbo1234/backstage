package com.zhaowb.boot.backstage.controller;

import com.zhaowb.boot.backstage.entity.User;
import com.zhaowb.boot.backstage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/findUserByLoginName")
    public User findUserByLoginName(String loginName){
        return userService.findUserByLoginName(loginName);
    }
}
