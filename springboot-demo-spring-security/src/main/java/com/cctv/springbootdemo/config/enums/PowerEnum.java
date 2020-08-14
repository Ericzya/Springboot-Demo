package com.cctv.springbootdemo.config.enums;

/**
 * @Author: Eric.Zhang
 * @Description: 用户角色枚举
 * @ProjectName: springboot-demo-spring-security
 * @Date: 2020/7/30 17:25
 */
public enum PowerEnum {
    /**
     * 管理员
     */
    Administrator("1"),
    /**
     * 监视者
     */
    Watcher("2"),
    /**
     * 用户
     */
    User("3"),
    /**
     * 游客
     */
    Visitor("4");


    private String code;

    PowerEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
