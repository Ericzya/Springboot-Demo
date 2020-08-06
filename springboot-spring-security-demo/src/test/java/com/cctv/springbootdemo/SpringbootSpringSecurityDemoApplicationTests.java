package com.cctv.springbootdemo;

import com.cctv.springbootdemo.service.visitor.svc.VisitorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringbootSpringSecurityDemoApplication.class)
@RunWith(SpringRunner.class)
class SpringbootSpringSecurityDemoApplicationTests {

    @Autowired
    private VisitorService visitorService;

    @Test
    void contextLoads() {
        System.out.println("测试");
        System.out.println("错误管理员：" + (visitorService.loginCheck("ericzya@outlook.com", "1") ? "登陆成功" : "登陆失败"));
        System.out.println("正确管理员：" + (visitorService.loginCheck("ericzya@outlook.com", "112233") ? "登陆成功" : "登陆失败"));
        System.out.println("错误用户：" + (visitorService.loginCheck("ericzya@outlook.com", "1") ? "登陆成功" : "登陆失败"));
        System.out.println("正确用户：" + (visitorService.loginCheck("ericzya@outlook.com", "112233") ? "登陆成功" : "登陆失败"));
    }

}
