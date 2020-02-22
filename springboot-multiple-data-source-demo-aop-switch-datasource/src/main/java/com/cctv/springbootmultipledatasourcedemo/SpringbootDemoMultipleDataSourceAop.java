package com.cctv.springbootmultipledatasourcedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * @Author: Eric
 * @Date: 2020/02/13 15:39
 */
@SpringBootApplication()
//@MapperScan("com.cctv.springbootmultipledatasourcedemo.persistent.*.pl")
public class SpringbootDemoMultipleDataSourceAop {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoMultipleDataSourceAop.class, args);
    }

}
