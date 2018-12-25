package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.RoleMenu;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuMapper {
    int deleteByPrimaryKey(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);

    int insert(RoleMenu record);

    List<RoleMenu> selectAll();
}