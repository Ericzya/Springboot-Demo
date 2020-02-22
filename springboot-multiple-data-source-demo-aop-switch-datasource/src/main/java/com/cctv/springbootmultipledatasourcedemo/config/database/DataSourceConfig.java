package com.cctv.springbootmultipledatasourcedemo.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import com.cctv.springbootmultipledatasourcedemo.config.enums.DataSourceEnum;
import com.cctv.springbootmultipledatasourcedemo.persistent.user.po.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
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
@MapperScan(basePackages = "com.cctv.springbootmultipledatasourcedemo.persistent.*.pl")
public class DataSourceConfig {
    @Bean(name = "dataSourceManager")
    @Primary
    public DataSource dataSourceMaster() throws Exception {
        ManagerConfig managerConfig=new ManagerConfig();
        DruidDataSource druidDataSourceMaster = new DruidDataSource();
        druidDataSourceMaster.setUrl(managerConfig.getUrl());
        druidDataSourceMaster.setUsername(managerConfig.getUsername());
        druidDataSourceMaster.setPassword(managerConfig.getPassword());
        druidDataSourceMaster.setDriverClassName(managerConfig.getDriverClassName());
        return druidDataSourceMaster;
    }

    @Bean(name = "dataSourceUser")
    public DataSource dataSourceSlave() throws Exception {
        DruidDataSource druidDataSourceUser = new DruidDataSource();
        UserConfig userConfig=new UserConfig();
        druidDataSourceUser.setUrl(userConfig.getUrl());
        druidDataSourceUser.setUsername(userConfig.getUsername());
        druidDataSourceUser.setPassword(userConfig.getPassword());
        druidDataSourceUser.setDriverClassName(userConfig.getDriverClassName());
        return druidDataSourceUser;
    }

    /**
     * 动态数据源，配置需要使用到的多个数据源
     *
     * @param managerSource
     * @param userSource
     * @return
     */
    @Bean
    public DynamicDataSource dynamicDataSource(@Qualifier("dataSourceManager") DataSource managerSource, @Qualifier("dataSourceUser") DataSource userSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        // 添加主库源
        targetDataSources.put(DataSourceEnum.DB_Manager, managerSource);
        targetDataSources.put(DataSourceEnum.DB_User, userSource);
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(managerSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DynamicDataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dynamicDataSource);
        sessionFactory.setMapperLocations(((ResourcePatternResolver) new PathMatchingResourcePatternResolver())
                .getResources("classpath*:/mapper/*/*DAO.xml"));
        return sessionFactory.getObject();
    }

}
