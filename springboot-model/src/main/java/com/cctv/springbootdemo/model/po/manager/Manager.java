package com.cctv.springbootdemo.model.po.manager;

/**
 * @Author: Eric.Zhang
 * @Description: 管理员实体类
 * @ProjectName: springboot-demo
 * @Date: 2020/7/30 17:21
 */
public class Manager {
    /**
     * 管理员编号
     */
    private Integer id;
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
    private String managerPower;
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

    @Override
    public String toString() {
        return "Manager{" +
                "managerId='" + managerId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerPower='" + managerPower + '\'' +
                ", managerPosition='" + managerPosition + '\'' +
                ", managerSexuality='" + managerSexuality + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public Manager() {
    }

    public Manager(Integer id, String managerId, String managerName, String managerPower, String managerPosition, String managerSexuality, String accountPassword, String emailAddress) {
        this.id = id;
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerPower = managerPower;
        this.managerPosition = managerPosition;
        this.managerSexuality = managerSexuality;
        this.accountPassword = accountPassword;
        this.emailAddress = emailAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getManagerPower() {
        return managerPower;
    }

    public void setManagerPower(String managerPower) {
        this.managerPower = managerPower;
    }

    public String getManagerPosition() {
        return managerPosition;
    }

    public void setManagerPosition(String managerPosition) {
        this.managerPosition = managerPosition;
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

