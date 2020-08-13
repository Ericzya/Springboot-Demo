package com.cctv.springbootdemo.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Eric
 * @Date: 2020/1/27 13:44
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login/login";
    }

}
