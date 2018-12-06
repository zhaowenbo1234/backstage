package com.zhaowb.boot.backstage.entity;

/**
 * 角色和部门关联 sys_role_dept
 *
 * @author zhaowb
 */
public class RoleDept {
    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取部门ID
     *
     * @return dept_id - 部门ID
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置部门ID
     *
     * @param deptId 部门ID
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}