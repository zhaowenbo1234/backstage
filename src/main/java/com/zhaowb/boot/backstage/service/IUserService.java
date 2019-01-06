package com.zhaowb.boot.backstage.service;

import com.zhaowb.boot.backstage.entity.User;
import com.zhaowb.boot.backstage.vo.UserSearchVO;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb [308539393@qq.com]
 * @date 2018/12/6 16:23
 */
public interface IUserService {
    /**
     * 获取全部未删除用户
     *
     * @return
     */
    List<User> selectAllUsers();

    /**
     * 根据用户登录名查询用户信息
     *
     * @param loginName 登录名
     * @return User
     */
    User findUserByUserName(String loginName);

    /**
     * 根据条件查询用户
     *
     * @param userSearchVO 用户查询 实体类
     * @return List<User> 用户列表
     */
    List<User> selectUserList(UserSearchVO userSearchVO);
}
