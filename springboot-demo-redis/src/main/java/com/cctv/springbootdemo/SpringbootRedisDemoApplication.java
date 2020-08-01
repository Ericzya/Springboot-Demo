package com.cctv.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author: Eric.Zhang
 * @Description: Springboot启动类
 * @ProjectName: springboot-demo
 * @Date: 2020/7/31 18:09
 */
@SpringBootApplication(scanBasePackages = "com.cctv")
@EnableCaching
public class SpringbootRedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisDemoApplication.class, args);
    }

}