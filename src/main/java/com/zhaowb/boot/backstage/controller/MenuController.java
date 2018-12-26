package com.zhaowb.boot.backstage.controller;

import com.github.pagehelper.PageInfo;
import com.zhaowb.boot.backstage.entity.Menu;
import com.zhaowb.boot.backstage.entity.User;
import com.zhaowb.boot.backstage.service.IMenuService;
import com.zhaowb.boot.backstage.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @auther zwb
 * @create 2018-12-23 16:34
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    /**
     * 根据登录用户ID查询菜单
     */
    @RequestMapping("/selectMenusByUserId")
    @ResponseBody
    public PageInfo<Menu> selectMenusByUserId(Integer userId) {
        return menuService.selectMenusByUserId(userId);
    }

    /**
     * 显示左侧用户的树形菜单
     * @return List<Menu>
     */
    @RequestMapping("/menus")
    @ResponseBody
    public List<Menu> menus(){
        User user = ShiroUtils.getSysUser();
        List<Menu> menus =  menuService.selectMenusByUserId(user.getUserId()).getList();
        return menus;
    }

}
