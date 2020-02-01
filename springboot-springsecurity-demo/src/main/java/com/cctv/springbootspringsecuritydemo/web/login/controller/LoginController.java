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
    public String login(@RequestParam("account") String managerAccount, @RequestParam("password") String inputPassword) {
        if (managerService.loginCheck(managerAccount, inputPassword)) {
            return "";
        } else {
            return "";
        }
    }
}
