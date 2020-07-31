package com.cctv.springbootdemo.aopswitch.config.dbconfig;

import com.cctv.springbootdemo.aopswitch.config.enums.DataSourceEnum;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Eric
 * @Date: 2020/2/13 14:16
 */
@Configuration
@MapperScan(basePackages = "com.cctv.springbootdemo.dao.*")
public class DataSourceConfig {
    @Bean(name = "dataSourceManager")
    @ConfigurationProperties(prefix = "spring.datasource.manager")
    public DataSource setDataSourceMaster() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSourceUser")
    @ConfigurationProperties(prefix = "spring.datasource.user")
    public DataSource setDatasourceUser() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源，配置需要使用到的多个数据源
     *
     * @return AbstractRoutingDataSource的继承类DynamicDataSource
     */
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(DataSourceEnum.DB_Manager, setDataSourceMaster());
        targetDataSources.put(DataSourceEnum.DB_User, setDatasourceUser());

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(setDataSourceMaster());
        //添加多个数据源
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DynamicDataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }

    @Bean
    public SqlSessionFactory setSqlSession(DynamicDataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dynamicDataSource);
        sessionFactory.setMapperLocations((new PathMatchingResourcePatternResolver())
                .getResources("classpath*:/mapper/*/*DAO.xml"));
        return sessionFactory.getObject();
    }

}
