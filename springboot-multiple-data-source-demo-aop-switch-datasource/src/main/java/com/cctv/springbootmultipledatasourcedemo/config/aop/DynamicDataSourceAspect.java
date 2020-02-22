package com.cctv.springbootmultipledatasourcedemo.config.aop;

import com.cctv.springbootmultipledatasourcedemo.config.database.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @Author: Eric
 * @Date: 2020/2/13 0:59
 */
public class DynamicDataSourceAspect {

    private final static Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(dataSourceAnnotation)")
    public void before(JoinPoint point, DataSourceAnnotation dataSourceAnnotation) {
//        Class<?> clazz = point.getTarget().getClass();
//        MethodSignature signature = (MethodSignature) point.getSignature();
        try {
//            Method method = clazz.getMethod(signature.getName(), signature.getParameterTypes());
//            if (method.isAnnotationPresent(DataSourceAnnotation.class)) {
            // 根据注解设置数据源
//                DataSourceAnnotation annotation = method.getAnnotation(DataSourceAnnotation.class);
            DataSourceHolder.setDataSource(dataSourceAnnotation.value());
            logger.info("设置" + dataSourceAnnotation.value() + "数据源");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After("@annotation(dataSourceAnnotation)")
    public void after(JoinPoint point, DataSourceAnnotation dataSourceAnnotation) {
        DataSourceHolder.setDefaultDataSource();
    }


//    /**
//     * 设置切点数据源
//     * <p>
//     * 调试输出数据源.
//     * </p>
//     *
//     * @param joinPoint     切点
//     * @param dataSourceKey 当前数据源键值
//     */
//    private void setDataSourceByKey(JoinPoint joinPoint, String dataSourceKey) {
//        setDataSource(dataSourceKey);
//        logger.debug(joinPoint.getTarget().getClass().getSimpleName() + "." + joinPoint.getSignature().getName() + "配置数据源：" + getDataSource());
//    }
//
//    /**
//     * 切换数据源
//     * <p>
//     * 切换优先级由高到底如下；方法上注解DataSourceKey，方法上注解ReadOnlyKey，类上注解DataSourceKey；<br>
//     * 如果未注解，则默认设置写数据源.
//     * </p>
//     *
//     * @param joinPoint 切点
//     * @see DataSourceAnnotation
//     * @see com.cctv.springbootmultipledatasourcedemo.config.enums.DataSourceEnum
//     */
//    public void switchDataSource(JoinPoint joinPoint) {
//        Class<?> targetClass = joinPoint.getTarget().getClass();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        DataSourceAnnotation dataSourceAnnotation = (DataSourceAnnotation) targetClass.getAnnotation(DataSourceAnnotation.class);
//        if (dataSourceAnnotation != null) {
//            setDataSourceByKey(joinPoint, dataSourceAnnotation.dataSourceKey());
//            return;
//        }
//        setDataSourceByKey(joinPoint, DataSourceEnum.DB_Manager.getDataSourceKey());
//    }
}
