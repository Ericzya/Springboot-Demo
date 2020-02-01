package com.cctv.springbootspringsecuritydemo.web.test;

import com.cctv.springbootspringsecuritydemo.SpringbootSpringSecurityDemoApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Eric
 * @Date: 2020/1/30 11:42
 */
@SpringBootTest(classes= SpringbootSpringSecurityDemoApplication.class)
@RunWith(SpringRunner.class)
class LoginControllerTest {

    private String rootUrl="http://localhost:8080/mcool";
    private TestRestTemplate template = new TestRestTemplate();

    @Test
    void getLoginPage() {
        String url = rootUrl+ "/login";
        String resultStr = template.getForObject(url, String.class);
        System.out.println(resultStr);
    }
}