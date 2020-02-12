package com.cctv.springbootmultipledatasourcedemo.config.database;

import com.cctv.springbootmultipledatasourcedemo.config.enums.DataSourceEnum;
import org.springframework.util.StringUtils;

/**
 * @Author: Eric
 * @Date: 2020/2/13 0:56
 */
public abstract class AbstractDBContextHolder {
    /**
     * 数据源类型管理
     * <p>
     * 考虑多线程，为保证线程之间互不干扰，所以使用ThreadLocal作线程隔离；<br>
     * 参数是数据源键值
     * </p>
     *
     * @see ThreadLocal
     */
    private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 获取数据源
     * <p>
     * 如果未设置，默认返回读数据源
     * </p>
     *
     * @return 数据源键值
     */
    public static String getDataSource() {
        String dataSource = contextHolder.get();
        if (StringUtils.isEmpty(dataSource)) {
            dataSource = DataSourceEnum.DB_Manager.getDataSourceKey();
        }
        return dataSource;
    }

    /**
     * 设置数据源
     *
     * @param dataSourceKey 数据源键值
     */
    public static void setDataSource(String dataSourceKey) {
        contextHolder.set(dataSourceKey);
    }
}
