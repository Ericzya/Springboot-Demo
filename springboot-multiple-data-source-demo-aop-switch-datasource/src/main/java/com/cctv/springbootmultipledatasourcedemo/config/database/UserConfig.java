package com.cctv.springbootmultipledatasourcedemo.config.database;

/**
 * @Author: Eric
 * @Date: 2020/2/13 14:29
 */
public class UserConfig {
    private String url="jdbc:mysql://localhost:3306/mcool-user?allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
    private String username="root";
    private String password="112233";
    private String driverClassName="com.mysql.cj.jdbc.Driver";

    public UserConfig() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
