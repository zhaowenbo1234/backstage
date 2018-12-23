package com.zhaowb.boot.backstage.service;

import com.zhaowb.boot.backstage.entity.Menu;

import java.util.List;

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
    List<Menu> selectMenusByUserId(Integer userId);
}
