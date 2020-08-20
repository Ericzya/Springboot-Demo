package com.cctv.springbootdemo.web.page.profile;

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
    /**
     * 个人资料页获取
     *
     * @return 个人资料页文件相对路径
     */
    @GetMapping("/profile")
    public String getProfilePage() {
        return "/index/profile";
    }
}
