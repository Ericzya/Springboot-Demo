package com.cctv.springbootdemo;

import com.cctv.springbootdemo.service.visitor.svc.VisitorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Eric.Zhang
 * @Description: VisitorService测试类
 * @ProjectName: springboot-demo-spring-security
 * @Date: 2020/7/30 17:25
 */
@SpringBootTest(classes = SpringbootSpringSecurityDemoApplication.class)
@RunWith(SpringRunner.class)
class SpringbootSpringSecurityDemoApplicationTests {

    @Autowired
    private VisitorService visitorService;

    @Test
    void contextLoads() {
        System.out.println("测试");
        System.out.println("错误管理员：" + (visitorService.loginCheck("ericzya@outlook.com", "1") ? "登陆成功" : "登陆失败"));
        System.out.println("正确管理员：" + (visitorService.loginCheck("ericzya@outlook.com", "$2a$10$P2kuPC.oCuNnhTjZDFYIteRDgvWzleqnfsxTs9WpXECJYmdrLpuNi") ? "登陆成功" : "登陆失败"));
    }

}
