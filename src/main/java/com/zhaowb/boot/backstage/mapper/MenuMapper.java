package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.Menu;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zhaowb
 */
@Repository
public interface MenuMapper extends Mapper<Menu> {

    /**
     * 根据登录用户ID查询菜单
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<Menu> selectMenusByUserId(Integer userId);
}