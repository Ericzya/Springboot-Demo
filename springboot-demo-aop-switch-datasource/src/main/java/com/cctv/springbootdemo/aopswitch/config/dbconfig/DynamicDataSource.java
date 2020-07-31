package com.cctv.springbootdemo.aopswitch.config.dbconfig;

import com.cctv.springbootdemo.aopswitch.config.enums.DataSourceEnum;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: Eric
 * @Date: 2020/2/13 14:34
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        //获取并设置数据源
        return DataSourceHolder.getDataSource();
    }
}
