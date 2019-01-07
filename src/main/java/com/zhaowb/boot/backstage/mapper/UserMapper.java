package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.User;
import com.zhaowb.boot.backstage.vo.UserSearchVO;
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
     * @param userSearchVO
     * @return List<User> 用户列表
     */
    List<User> selectUserList(UserSearchVO userSearchVO);


    /**
     * 根据用户ID删除用户
     * @param userId 待删除用户ID
     * @return
     */
    Integer deleteUserByUserId(Integer userId);

    /**
     * 批量根据用户ID删除用户
     * @param userIds 用户iD数组
     * @return
     */
    Integer deleteUserByIds(Integer[] userIds);
}