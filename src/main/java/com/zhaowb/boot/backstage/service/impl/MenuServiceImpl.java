package com.zhaowb.boot.backstage.service.impl;

import com.zhaowb.boot.backstage.entity.Menu;
import com.zhaowb.boot.backstage.mapper.MenuMapper;
import com.zhaowb.boot.backstage.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Description
 * @auther zwb
 * @create 2018-12-23 20:57
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Set<Menu> selectMenuByUserId(Integer userId) {
        Set<Menu> menus = menuMapper.selectMenusByUserId(userId);
        return menus;
    }
}
