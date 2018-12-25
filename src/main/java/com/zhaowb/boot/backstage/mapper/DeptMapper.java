package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept record);

    Dept selectByPrimaryKey(Integer deptId);

    List<Dept> selectAll();

    int updateByPrimaryKey(Dept record);
}