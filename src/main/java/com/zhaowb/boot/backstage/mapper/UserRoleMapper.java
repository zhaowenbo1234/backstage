package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.UserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    int insert(UserRole record);

    List<UserRole> selectAll();
}