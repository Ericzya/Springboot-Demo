package com.cctv.springbootdemo.web.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Eric.Zhang
 * @Description: 个人资料页Controller
 * @ProjectName: springboot-demo-spring-security
 * @Date: 2020/7/30 17:25
 */
@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String getProfilePage(){
        return "/index/profile";
    }
}
