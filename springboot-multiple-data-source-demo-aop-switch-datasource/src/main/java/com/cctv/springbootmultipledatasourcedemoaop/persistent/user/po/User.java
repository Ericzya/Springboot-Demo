package com.cctv.springbootmultipledatasourcedemoaop.persistent.user.po;

import java.util.Date;

/**
 * @Author: Eric
 * @Date: 2020/1/27 15:42
 */
public class User {
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
