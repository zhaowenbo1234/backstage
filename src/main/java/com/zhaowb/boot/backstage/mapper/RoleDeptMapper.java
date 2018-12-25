package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.RoleDept;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDeptMapper {
    int deleteByPrimaryKey(@Param("roleId") Integer roleId, @Param("deptId") Integer deptId);

    int insert(RoleDept record);

    List<RoleDept> selectAll();
}