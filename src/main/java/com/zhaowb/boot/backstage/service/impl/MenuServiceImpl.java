package com.zhaowb.boot.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaowb.boot.backstage.entity.Menu;
import com.zhaowb.boot.backstage.mapper.MenuMapper;
import com.zhaowb.boot.backstage.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public PageInfo<Menu> selectMenusByUserId(Integer userId) {

        PageHelper.startPage(1,10);
        List list = menuMapper.selectMenusByUserId(userId);
        PageInfo pageInfo = new PageInfo(list);

        return pageInfo;
    }
}
