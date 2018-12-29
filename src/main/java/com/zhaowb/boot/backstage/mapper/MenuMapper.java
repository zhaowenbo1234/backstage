package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu record);

    List<Menu> selectMenusByUserId(Integer userId);
}