package com.cctv.springbootredisdemo;

import com.cctv.springbootredisdemo.service.svc.ManagerService;
import com.cctv.springbootredisdemo.service.svc.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringbootRedisDemoApplicationTests {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserService userService;

    @Test
    void managerDataSource() {
        System.out.println("测试");
        System.out.println("错误管理员：" + (managerService.loginCheck("ericzya@outlook.com", "1") ? "登陆成功" : "登陆失败"));
        System.out.println("正确管理员：" + (managerService.loginCheck("ericzya@outlook.com", "112233") ? "登陆成功" : "登陆失败"));
        System.out.println("错误用户：" + (userService.loginCheck("ericzya@outlook.com", "1") ? "登陆成功" : "登陆失败"));
        System.out.println("正确用户：" + (userService.loginCheck("ericzya@outlook.com", "445566") ? "登陆成功" : "登陆失败"));
    }

}
