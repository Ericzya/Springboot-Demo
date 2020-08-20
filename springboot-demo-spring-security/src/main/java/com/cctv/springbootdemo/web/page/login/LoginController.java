package com.cctv.springbootdemo.web.page.login;

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
    /**
     * 登录页获取
     *
     * @return 登录页文件相对路径
     */
    @GetMapping("/login")
    public String getLoginPage() {
        return "login/login";
    }
}
