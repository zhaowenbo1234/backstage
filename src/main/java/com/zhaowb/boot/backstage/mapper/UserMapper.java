package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User findUserByUserName(String loginName);

    /**
     * 根据条件查询用户
     * @param user
     * @return List<User> 用户列表
     */
    List<User> selectUserByDeptId(User user);
}