package com.cctv.springbootdemo.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Eric.Zhang
 * @Description: 登录页Controller
 * @ProjectName: springboot-demo-spring-security
 * @Date: 2020/7/30 17:25
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage() {
        return "login/login";
    }
}
