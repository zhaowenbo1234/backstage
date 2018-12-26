package com.zhaowb.boot.backstage.service;

import com.github.pagehelper.PageInfo;
import com.zhaowb.boot.backstage.entity.Menu;

/**
 * @Description
 * @auther zwb
 * @create 2018-12-23 20:57
 */
public interface IMenuService {

    /**
     * 根据登录用户ID查询菜单
     * @param userId 用户ID
     * @return 菜单列表
     */
    PageInfo<Menu> selectMenusByUserId(Integer userId);
}
