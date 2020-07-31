package com.cctv.springbootdemo.aopswitch.config.enums;

/**
 * @author ericz
 */

public enum DataSourceEnum {
    /**
     * 管理员库
     */
    DB_Manager("Manager"),
    /**
     * 用户库
     */
    DB_User("User");

    /**
     * 数据源关键字
     */
    private String dataSourceKey;

    DataSourceEnum(String dataSourceKey) {
        this.dataSourceKey = dataSourceKey;
    }

    public String getDataSourceKey() {
        return dataSourceKey;
    }
}