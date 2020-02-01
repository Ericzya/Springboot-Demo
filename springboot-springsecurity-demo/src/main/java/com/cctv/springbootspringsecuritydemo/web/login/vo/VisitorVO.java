package com.cctv.springbootspringsecuritydemo.web.login.vo;

/**
 * @Author: Eric
 * @Date: 2020/1/30 12:47
 */
public class VisitorVO {
    private String inputAccount;
    private String inputPassword;

    @Override
    public String toString() {
        return "VisitorBO{" +
                "inputAccount='" + inputAccount + '\'' +
                ", inputPassword='" + inputPassword + '\'' +
                '}';
    }

    public String getInputAccount() {
        return inputAccount;
    }

    public void setInputAccount(String inputAccount) {
        this.inputAccount = inputAccount;
    }

    public String getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }
}
