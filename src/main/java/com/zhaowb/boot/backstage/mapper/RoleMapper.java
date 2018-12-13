package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.Role;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zhaowb
 */
@Repository
public interface RoleMapper extends Mapper<Role> {
}