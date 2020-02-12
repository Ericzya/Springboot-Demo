package com.cctv.springbootmultipledatasourcedemo.service.manager.bo;

import java.util.List;

/**
 * @Author: Eric
 * @Date: 2020/1/9 20:01
 */
public class ManagerBO {
    /**
     * 管理员账号
     */
    private String managerId;
    /**
     * 管理员名称
     */
    private String managerName;
    /**
     * 管理员权限集合
     */
    private List<String> managerPower;
    /**
     * 管理员职位
     */
    private String managerPosition;
    /**
     * 管理员性别
     */
    private String managerSexuality;
    /**
     * 管理员账号密码
     */
    private String accountPassword;
    /**
     * 管理员邮箱
     */
    private String emailAddress;

    public ManagerBO(String managerId, String managerName, List<String> managerPower, String managerPosition, String managerSexuality, String accountPassword, String emailAddress) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerPower = managerPower;
        this.managerPosition = managerPosition;
        this.managerSexuality = managerSexuality;
        this.accountPassword = accountPassword;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "ManagerBO{" +
                "managerAccount='" + managerId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerPower=" + managerPower +
                ", managerPosition='" + managerPosition + '\'' +
                ", managerSexuality='" + managerSexuality + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPosition() {
        return managerPosition;
    }

    public void setManagerPosition(String managerPosition) {
        this.managerPosition = managerPosition;
    }

    public List<String> getManagerPower() {
        return managerPower;
    }

    public void setManagerPower(List<String> managerPower) {
        this.managerPower = managerPower;
    }

    public String getManagerSexuality() {
        return managerSexuality;
    }

    public void setManagerSexuality(String managerSexuality) {
        this.managerSexuality = managerSexuality;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
