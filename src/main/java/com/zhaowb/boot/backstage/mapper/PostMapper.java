package com.zhaowb.boot.backstage.mapper;

import com.zhaowb.boot.backstage.entity.Post;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zhaowb
 * @date 2018-12-6
 */
@Repository
public interface PostMapper extends Mapper<Post> {
}