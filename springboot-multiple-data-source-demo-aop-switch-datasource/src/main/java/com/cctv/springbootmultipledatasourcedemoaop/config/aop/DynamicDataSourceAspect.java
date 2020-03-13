package com.cctv.springbootmultipledatasourcedemoaop.config.aop;

import com.cctv.springbootmultipledatasourcedemoaop.config.database.DataSourceHolder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: Eric
 * @Date: 2020/2/13 0:59
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    private final static Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(dataSourceAnnotation)")
    public void before(DataSourceAnnotation dataSourceAnnotation) {
        try {
            DataSourceHolder.setDataSource(dataSourceAnnotation.value());
            logger.info("设置当前数据源为：" + dataSourceAnnotation.value());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After("@annotation(dataSourceAnnotation)")
    public void after(DataSourceAnnotation dataSourceAnnotation) {
        DataSourceHolder.setDefaultDataSource();
        logger.info("还原当前数据源为：" + DataSourceHolder.getDefaultDataSource());
    }
}
