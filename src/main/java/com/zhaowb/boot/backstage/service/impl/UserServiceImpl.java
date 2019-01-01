package com.zhaowb.boot.backstage.service.impl;

import com.zhaowb.boot.backstage.entity.User;
import com.zhaowb.boot.backstage.mapper.UserMapper;
import com.zhaowb.boot.backstage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb [308539393@qq.com]
 * @date 2018/12/6 16:24
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAllUsers() {

        return userMapper.selectAll();
    }

    @Override
    public User findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }

    private void deleteUserById(Integer id){

        int i = userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> selectUserList(User user) {
        return userMapper.selectUserList(user);
    }
}
