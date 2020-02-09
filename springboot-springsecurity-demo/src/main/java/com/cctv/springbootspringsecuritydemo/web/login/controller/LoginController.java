package com.cctv.springbootspringsecuritydemo.web.login.controller;

import com.cctv.springbootspringsecuritydemo.service.manager.svc.ManagerService;
import com.cctv.springbootspringsecuritydemo.web.login.vo.VisitorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Eric
 * @Date: 2020/1/27 13:44
 */
@Controller
public class LoginController {
    private ManagerService managerService;

    @Autowired
    public LoginController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/login")
    public String getLoginPage(@ModelAttribute("visitor")VisitorVO visitorVO) {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("visitor")VisitorVO visitorVO) {
        //TODO 区分登陆用户为管理员还是用户
        if (managerService.loginCheck(visitorVO.getInputAccount(), visitorVO.getInputPassword())) {
            return "index/dashboard";
        } else {
            return "index/404";
        }
    }
}
