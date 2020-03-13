package com.cctv.springbootmultipledatasourcedemoaop.config.database;

import com.cctv.springbootmultipledatasourcedemoaop.config.enums.DataSourceEnum;

/**
 * @Author: Eric
 * @Date: 2020/2/13 0:56
 */
public class DataSourceHolder {
    public static final DataSourceEnum DEFAULT_DATA_SOURCE = DataSourceEnum.DB_Manager;

    /**
     * 数据源类型管理
     * <p>
     * 考虑多线程，为保证线程之间互不干扰，所以使用ThreadLocal作线程隔离；<br>
     * 参数是数据源键值
     * </p>
     *
     * @see ThreadLocal
     */
    private static final ThreadLocal<DataSourceEnum> contextHolder = new ThreadLocal<DataSourceEnum>() {
        @Override
        protected DataSourceEnum initialValue() {
            return DEFAULT_DATA_SOURCE;
        }
    };

    /**
     * 获取数据源
     * <p>
     * 如果未设置，默认返回读数据源
     * </p>
     *
     * @return 数据源键值
     */
    public static DataSourceEnum getDataSource() {
        return contextHolder.get();
    }

    /**
     * 设置默认数据源
     */
    public static void setDefaultDataSource() {
        contextHolder.set(DEFAULT_DATA_SOURCE);
    }

    /**
     * 获取默认数据源
     */
    public static DataSourceEnum getDefaultDataSource() {
        return DEFAULT_DATA_SOURCE;
    }

    /**
     * 设置数据源
     *
     * @param dataSourceEnum 数据源键值
     */
    public static void setDataSource(DataSourceEnum dataSourceEnum) {
        contextHolder.set(dataSourceEnum);
    }
}