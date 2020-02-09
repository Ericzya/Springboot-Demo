package com.cctv.springbootspringsecuritydemo.web.login.controller;

import com.cctv.springbootspringsecuritydemo.service.visitor.svc.VisitorService;
import com.cctv.springbootspringsecuritydemo.web.login.vo.VisitorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: Eric
 * @Date: 2020/1/27 13:44
 */
@Controller
public class LoginController {
    private VisitorService visitorService;

    @Autowired
    public LoginController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping("/login")
    public String getLoginPage(@ModelAttribute("visitor") VisitorVO visitorVO) {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("visitor") VisitorVO visitorVO) {
        if (visitorService.loginCheck(visitorVO.getInputAccount(), visitorVO.getInputPassword())) {
            return "index/index";
        } else {
            return "index/404";
        }
    }
}
