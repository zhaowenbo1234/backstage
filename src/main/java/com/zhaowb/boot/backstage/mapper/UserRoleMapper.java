package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.UserRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zhaowb
 */
@Repository
public interface UserRoleMapper extends Mapper<UserRole> {
}