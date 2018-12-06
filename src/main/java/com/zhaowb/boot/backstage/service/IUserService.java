package com.zhaowb.boot.backstage.service;

import com.zhaowb.boot.backstage.entity.User;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb [308539393@qq.com]
 * @date 2018/12/6 16:23
 */
public interface IUserService {
    /**
     * 获取全部用户
     * @return
     */
    List<User> getAllUser();

    /**
     *根据用户登录名查询用户信息
     * @param loginName 登录名
     * @return User
     */
    User findUserByLoginName(String loginName);
}
