package com.cctv.springbootspringsecuritydemo.service.visitor;

/**
 * @Author: Eric
 * @Date: 2020/1/30 12:45
 */
public class VisitorBO {
    private String inputAccount;
    private String inputPassword;

    public VisitorBO(String inputAccount, String inputPassword) {
        this.inputAccount = inputAccount;
        this.inputPassword = inputPassword;
    }

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
