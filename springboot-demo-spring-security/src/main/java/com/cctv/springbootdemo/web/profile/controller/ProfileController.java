package com.cctv.springbootdemo.web.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Eric
 * @Date: 2020/2/9 15:47
 */
@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String getProfilePage(){
        return "/index/profile";
    }
}
