package com.zhaowb.boot.backstage.entity;

/**
 * 用户和岗位关联 sys_user_post
 *
 * @author zhaowb
 */
public class UserPost {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 岗位ID
     */
    private Integer postId;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取岗位ID
     *
     * @return post_id - 岗位ID
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * 设置岗位ID
     *
     * @param postId 岗位ID
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}