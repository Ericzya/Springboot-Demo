package com.cctv.springbootdemo.web.login;

import com.cctv.springbootdemo.SpringbootSpringSecurityDemoApplication;
import com.cctv.springbootdemo.service.visitor.svc.VisitorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Eric
 * @Date: 2020/1/30 11:42
 */
@SpringBootTest(classes = SpringbootSpringSecurityDemoApplication.class)
@RunWith(SpringRunner.class)
class LoginControllerTest {
    @Autowired
    private VisitorService visitorService;

    @Test
    void getLoginPage() {
        visitorService.loginCheck("ericzya@outlook.com", "112233");
    }

}