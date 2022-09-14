package com.equipment_dictionary.model;

import java.util.Date;

public class User {
    private int userId;
    private String userName;
    private String userType;
    private String password;
    private Date createTime;
    private int isdel;

    public User(){}
    public User(int userId, String userName, String userType, String password, Date createTime, int isdel) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.password = password;
        this.createTime = createTime;
        this.isdel = isdel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getIsdel() {
        return isdel;
    }

    public void setIsdel(int isdel) {
        this.isdel = isdel;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", isdel=" + isdel +
                '}';
    }
}
