package com.zhaowb.boot.backstage.controller;

import com.zhaowb.boot.backstage.entity.User;
import com.zhaowb.boot.backstage.service.IUserService;
import com.zhaowb.boot.backstage.vo.UserSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb [308539393@qq.com]
 * @date 2018/12/6 17:48
 */
@Controller
@RequestMapping("user")
public class UserController {

    private final String PREFIX = "/user";

    @Autowired
    private IUserService userService;

    @GetMapping
    public String users() {
        return PREFIX + "/user";
    }

    @RequestMapping("/findUserByUserName")
    public User findUserByUserName(String username) {
        return userService.findUserByUserName(username);
    }

    /**
     * 查询所有用户（未删除的）
     *
     * @return List<User>
     */
    @RequestMapping("/selectAllUsers")
    @ResponseBody
    public List<User> selectAllUsers() {
        return userService.selectAllUsers();
    }

    @RequestMapping(value = "/selectUserList",method = RequestMethod.POST)
    public List<User> selectUserList(UserSearchVO userSearchVO){
        return userService.selectUserList(userSearchVO);
    }
}
