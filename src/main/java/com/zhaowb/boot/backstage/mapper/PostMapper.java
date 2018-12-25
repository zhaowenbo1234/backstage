package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostMapper {
    int deleteByPrimaryKey(Integer postId);

    int insert(Post record);

    Post selectByPrimaryKey(Integer postId);

    List<Post> selectAll();

    int updateByPrimaryKey(Post record);
}