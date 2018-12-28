package com.zhaowb.boot.backstage.util;

import com.zhaowb.boot.backstage.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther zwb
 * @create 2018-12-28 14:49
 */
public class TreeUtils {

    public static List<Menu> build(List<Menu> treeNodes, Object root) {
        List<Menu> menus = new ArrayList<>();
        for (Menu menu : treeNodes) {
            if (root.equals(menu.getParentId())) {
                menus.add(menu);
            }

            for (Menu it : treeNodes) {
                if (it.getParentId() == menu.getMenuId()) {
                    if (menu.getParentId() == null) {
                        menu.setChildren(new ArrayList<>());
                    }
                    menu.add(it);
                }
            }
        }
        return menus;
    }

}
