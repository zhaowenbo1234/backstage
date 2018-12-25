package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.UserPost;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("postId") Integer postId);

    int insert(UserPost record);

    List<UserPost> selectAll();
}