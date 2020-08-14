package com.cctv.springbootdemo.web.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Eric.Zhang
 * @Description: 主页Controller
 * @ProjectName: springboot-demo-spring-security
 * @Date: 2020/7/30 17:25
 */
@Controller
public class IndexController {
    @GetMapping("/index")
    public String getIndexPage() {
        return "index/index";
    }
}
