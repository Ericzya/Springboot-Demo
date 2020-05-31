package com.cctv.springbootspringsecuritydemo.config.enums;

/**
 * @Author: Eric
 * @Date: 2020/2/9 16:51
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
