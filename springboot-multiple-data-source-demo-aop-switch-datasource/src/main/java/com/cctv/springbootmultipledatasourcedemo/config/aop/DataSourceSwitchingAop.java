package com.cctv.springbootmultipledatasourcedemo.config.aop;

import com.cctv.springbootmultipledatasourcedemo.config.enums.DataSourceEnum;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cctv.springbootmultipledatasourcedemo.config.database.AbstractDBContextHolder.getDataSource;
import static com.cctv.springbootmultipledatasourcedemo.config.database.AbstractDBContextHolder.setDataSource;

/**
 * @Author: Eric
 * @Date: 2020/2/13 0:59
 */
public class DataSourceSwitchingAop {

    private final static Logger logger = LoggerFactory.getLogger(DataSourceSwitchingAop.class);

    /**
     * 设置切点数据源
     * <p>
     * 调试输出数据源.
     * </p>
     *
     * @param joinPoint     切点
     * @param dataSourceKey 当前数据源键值
     */
    private void setDataSourceByKey(JoinPoint joinPoint, String dataSourceKey) {
        setDataSource(dataSourceKey);
        logger.debug(joinPoint.getTarget().getClass().getSimpleName() + "." + joinPoint.getSignature().getName() + "配置数据源：" + getDataSource());
    }

    /**
     * 切换数据源
     * <p>
     * 切换优先级由高到底如下；方法上注解DataSourceKey，方法上注解ReadOnlyKey，类上注解DataSourceKey；<br>
     * 如果未注解，则默认设置写数据源.
     * </p>
     *
     * @param joinPoint 切点
     * @see DataSourceKey
     * @see com.cctv.springbootmultipledatasourcedemo.config.enums.DataSourceEnum
     */
    public void switchDataSource(JoinPoint joinPoint) {
        Class<?> targetClass = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        DataSourceKey dataSourceKey = (DataSourceKey) targetClass.getAnnotation(DataSourceKey.class);
        if (dataSourceKey != null) {
            setDataSourceByKey(joinPoint, dataSourceKey.dataSourceKey());
            return;
        }
        setDataSourceByKey(joinPoint, DataSourceEnum.DB_Manager.getDataSourceKey());
    }
}
