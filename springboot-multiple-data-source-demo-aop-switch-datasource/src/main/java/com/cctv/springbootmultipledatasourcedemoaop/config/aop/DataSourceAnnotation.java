package com.cctv.springbootmultipledatasourcedemoaop.config.aop;

import com.cctv.springbootmultipledatasourcedemoaop.config.enums.DataSourceEnum;

import java.lang.annotation.*;

/**
 * @Author: Eric
 * @Date: 2020/2/13 1:10
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DataSourceAnnotation {
    /**
     * 配置数据源键值
     * <p>
     * 默认：dataSource.
     * </p>
     *
     * @return 枚举
     */
    DataSourceEnum value() default DataSourceEnum.DB_Manager;
}
