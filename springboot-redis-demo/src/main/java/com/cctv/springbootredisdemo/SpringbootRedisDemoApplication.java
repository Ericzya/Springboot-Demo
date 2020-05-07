package com.cctv.springbootredisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author ericz
 */
@SpringBootApplication
@EnableCaching
public class SpringbootRedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisDemoApplication.class, args);
    }

}
