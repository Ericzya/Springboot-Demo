package com.cctv.springbootredisdemo;

import com.cctv.springbootredisdemo.persistent.manager.po.Manager;
import com.cctv.springbootredisdemo.service.manager.svc.ManagerService;
import com.cctv.springbootredisdemo.service.user.svc.UserService;
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

    @Test
    void insertUsers() {
        //插入五百万条数据
        for (int i = 0; i < 5000000; i++) {
            Manager manager = new Manager();
            manager.setManagerId(i+"");
            manager.setEmailAddress(i + "@qq.com");
            manager.setAccountPassword(i + "");
            manager.setManagerName("用户" + i);
            manager.setManagerSexuality("M");
            manager.setManagerPosition("不知道");
            manager.setManagerPower(i + "权限");
            managerService.insertManager(manager);
            log.info("插入到第" + i + "条数据！");
        }
    }

}
