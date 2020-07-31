package com.cctv.springbootdemo.model.po.user;

import java.util.Date;

/**
 * @Author: Eric.Zhang
 * @Description: 用户实体类
 * @ProjectName: springboot-demo
 * @Date: 2020/7/30 17:22
 */
public class User {
    /**
     * 用户账号
     */
    private String userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户性别
     */
    private String userSexuality;
    /**
     * 用户账号密码
     */
    private String accountPassword;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户生日
     */
    private Date userBirthday;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userSexuality='" + userSexuality + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthday=" + userBirthday +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSexuality() {
        return userSexuality;
    }

    public void setUserSexuality(String userSexuality) {
        this.userSexuality = userSexuality;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
}
