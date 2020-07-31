package com.cctv.springbootdemo.model.bo.user;

import java.util.Date;

/**
 * @Author: Eric.Zhang
 * @Description: 用户BO类
 * @ProjectName: springboot-demo
 * @Date: 2020/7/31 9:54
 */
public class UserBO {
    /**
     * 用户账号
     */
    private String userAccount;
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

    public UserBO(String userAccount, String userName, String userSexuality, String accountPassword, String userEmail, Date userBirthday) {
        this.userAccount = userAccount;
        this.userName = userName;
        this.userSexuality = userSexuality;
        this.accountPassword = accountPassword;
        this.userEmail = userEmail;
        this.userBirthday = userBirthday;
    }

    @Override
    public String toString() {
        return "UserBO{" +
                "userAccount='" + userAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", userSexuality='" + userSexuality + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthday=" + userBirthday +
                '}';
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
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
