package com.cctv.springbootmultipledatasourcedemo.persistent.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

/**
 * @Author: Eric
 * @Date: 2020/1/27 15:35
 */
@Configuration
@MapperScan(basePackages = "com.cctv.springbootmultipledatasourcedemo.persistent.manager", sqlSessionTemplateRef = "managerSqlSessionTemplate")
public class MybatisConfigManager {
    @Bean(name = "managerDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.manager")
    @Primary
    public DataSource customDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "managerSqlSessionFactory")
    @Primary
    public SqlSessionFactory customSqlSessionFactory(@Qualifier("managerDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/manager/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "managerTransactionManager")
    @Primary
    public DataSourceTransactionManager customTransactionManager(@Qualifier("managerDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "managerSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate customSqlSessionTemplate(@Qualifier("managerSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}