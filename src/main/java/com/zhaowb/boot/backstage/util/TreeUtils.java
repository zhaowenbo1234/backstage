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

    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @param root      父节点ID
     * @return
     */
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

    /**
     * 使用递归方法建树
     *
     * @param treeNodes 传入的树节点列表
     * @param root      父节点ID
     * @return
     */
    public static List<Menu> buildByRecursive(List<Menu> treeNodes, Object root) {

        List<Menu> menus = new ArrayList<>();
        for (Menu menu : treeNodes) {
            if (root.equals(menu.getParentId())) {
                menus.add(findChildren(menu, treeNodes));
//                menus.add(menu);
            }
        }
        return menus;
    }

    public static Menu findChildren(Menu treeNode, List<Menu> treeNodes) {
        for (Menu menu : treeNodes) {
            if (treeNode.getMenuId() == menu.getParentId()) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.add(findChildren(menu, treeNodes));
            }
        }
        return treeNode;
    }

}
