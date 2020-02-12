package com.cctv.springbootmultipledatasourcedemo.config.enums;

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
    private String dataSourceKey;

    DataSourceEnum(String dataSourceKey) {
        this.dataSourceKey = dataSourceKey;
    }

    public String getDataSourceKey() {
        return dataSourceKey;
    }
}