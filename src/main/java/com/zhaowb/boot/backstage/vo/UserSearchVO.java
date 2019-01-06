package com.zhaowb.boot.backstage.vo;

import java.util.Date;

/**
 * @Description 在页面查询时使用
 * @auther zwb
 * @create 2019-01-06 19:03
 */
public class UserSearchVO {
    /**
     * 部门id
     */
    private Integer deptId;
    /**
     * 创建开始时间
     */
    private Date startDate;
    /**
     * 创建结束时间
     */
    private Date endDate;
    /**
     * 用户名
     */
    private String username;
    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 电话号码
     */
    private String telPhone;

    /**
     * 状态
     */
    private String status;

    public UserSearchVO(Integer deptId, Date startDate, Date endDate, String username, String name, String phoneNumber, String telPhone, String status) {
        this.deptId = deptId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.username = username;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.telPhone = telPhone;
        this.status = status;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserSearchVO{" +
                "deptId=" + deptId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
