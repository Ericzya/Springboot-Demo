package com.cctv.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Eric
 * @Date: 2020/1/27 15:39
 */
@SpringBootApplication(scanBasePackages = "com.cctv.springbootdemo")
public class SpringbootDifferentPackagesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDifferentPackagesDemoApplication.class, args);
    }

}
