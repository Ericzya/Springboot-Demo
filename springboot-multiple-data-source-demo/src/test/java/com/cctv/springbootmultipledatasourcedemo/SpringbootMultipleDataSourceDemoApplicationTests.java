package com.cctv.springbootmultipledatasourcedemo;

import com.cctv.springbootmultipledatasourcedemo.service.manager.svc.ManagerService;
import com.cctv.springbootmultipledatasourcedemo.service.user.svc.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringbootMultipleDataSourceDemoApplication.class)
@RunWith(SpringRunner.class)
class SpringbootMultipleDataSourceDemoApplicationTests {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        System.out.println("测试");
        System.out.println("错误管理员：" + (managerService.loginCheck("ericzya@outlook.com", "1") ? "登陆成功" : "登陆失败"));
        System.out.println("正确管理员：" + (managerService.loginCheck("ericzya@outlook.com", "112233") ? "登陆成功" : "登陆失败"));
        System.out.println("错误用户：" + (userService.loginCheck("ericzya@outlook.com", "1") ? "登陆成功" : "登陆失败"));
        System.out.println("正确用户：" + (userService.loginCheck("ericzya@outlook.com", "445566") ? "登陆成功" : "登陆失败"));
    }

}
