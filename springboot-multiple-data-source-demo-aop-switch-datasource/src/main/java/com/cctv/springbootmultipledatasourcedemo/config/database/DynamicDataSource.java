package com.cctv.springbootmultipledatasourcedemo.config.database;

import com.cctv.springbootmultipledatasourcedemo.config.enums.DataSourceEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: Eric
 * @Date: 2020/2/13 14:34
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private final Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceEnum dataSourceEnum = DataSourceHolder.getDataSource();
        logger.info("当前使用数据源为：{}", dataSourceEnum);
        return dataSourceEnum;
    }
}
