package com.cctv.springbootspringsecuritydemo.web.login;

import com.cctv.springbootspringsecuritydemo.service.manager.svc.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

//    @GetMapping("/login")
//    public String getLoginPage() {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam("account") String managerAccount, @RequestParam("password") String inputPassword) {
//        if (managerService.loginCheck(managerAccount, inputPassword)) {
//            return "";
//        } else {
//            return "";
//        }
//    }
}
