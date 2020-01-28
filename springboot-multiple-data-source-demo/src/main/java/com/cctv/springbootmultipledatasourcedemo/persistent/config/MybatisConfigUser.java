package com.cctv.springbootmultipledatasourcedemo.persistent.config;

/**
 * @Author: Eric
 * @Date: 2020/1/27 15:39
 */

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.cctv.springbootmultipledatasourcedemo.persistent.user", sqlSessionTemplateRef = "userSqlSessionTemplate")
public class MybatisConfigUser {
    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user")
    public DataSource customDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory customSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/user/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "userTransactionManager")
    public DataSourceTransactionManager customTransactionManager(@Qualifier("userDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "userSqlSessionTemplate")
    public SqlSessionTemplate customSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
