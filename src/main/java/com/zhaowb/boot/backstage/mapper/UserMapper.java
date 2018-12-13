package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zhaowb
 */
@Repository
public interface UserMapper extends Mapper<User> {

    /**
     * 根据用户登录名查询用户信息
     *
     * @param userName 登录名
     * @return User
     */
    User findUserByUserName(String userName);
}