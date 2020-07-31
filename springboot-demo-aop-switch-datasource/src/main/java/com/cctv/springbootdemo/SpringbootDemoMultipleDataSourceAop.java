package com.cctv.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @Author: Eric
 * @Date: 2020/02/13 15:39
 */
@SpringBootApplication(scanBasePackages = "com.cctv")
public class SpringbootDemoMultipleDataSourceAop {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoMultipleDataSourceAop.class, args);
    }

}
