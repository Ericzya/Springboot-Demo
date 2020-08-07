package com.cctv.springbootdemo.model.vo;

/**
 * @Author: Eric.Zhang
 * @Description: 访问者VO
 * @ProjectName: springboot-demo
 * @Date: 2020/8/6 17:56
 */
public class VisitorVO {
    private String inputAccount;
    private String inputPassword;

    public VisitorVO() {
    }

    @Override
    public String toString() {
        return "VisitorVO{" +
                "inputAccount='" + inputAccount + '\'' +
                ", inputPassword='" + inputPassword + '\'' +
                '}';
    }

    public VisitorVO(String inputAccount, String inputPassword) {
        this.inputAccount = inputAccount;
        this.inputPassword = inputPassword;
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
