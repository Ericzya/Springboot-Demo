package com.cctv.springbootmultipledatasourcedemoaop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cctv.springbootdemo.SpringbootDemoMultipleDataSourceAop;
import com.cctv.springbootdemo.dao.manager.ManagerDAO;
import com.cctv.springbootdemo.model.po.manager.Manager;
import com.cctv.springbootdemo.service.manager.ManagerService;
import com.cctv.springbootdemo.service.user.UserService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SpringbootDemoMultipleDataSourceAop.class)
@RunWith(SpringRunner.class)
class SpringbootDemoMultipleDataSourceAopTests {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserService userService;

    @Autowired
    private ManagerDAO managerDAO;

    @Test
    void managerDataSource() {
        System.out.println("测试");
        System.out.println("错误管理员：" + (managerService.loginCheck("ericzya@outlook.com", "1") ? "登陆成功" : "登陆失败"));
        System.out.println("正确管理员：" + (managerService.loginCheck("ericzya@outlook.com", "$2a$10$P2kuPC.oCuNnhTjZDFYIteRDgvWzleqnfsxTs9WpXECJYmdrLpuNi") ? "登陆成功" : "登陆失败"));
        System.out.println("错误用户：" + (userService.loginCheck("ericzya@outlook.com", "1") ? "登陆成功" : "登陆失败"));
        System.out.println("正确用户：" + (userService.loginCheck("ericzya@outlook.com", "445566") ? "登陆成功" : "登陆失败"));
    }

    @Test
    void insertTest() {
        System.out.println("----------------insert test-----------------");
        Manager manager = new Manager();
        manager.setManagerId("2");
        manager.setManagerName("ahaha");
        manager.setManagerSexuality("M");
        manager.setAccountPassword("111");
        manager.setEmailAddress("xxx@outlook.com");
        managerDAO.insertManager(manager);
        System.out.println("插入" + JSON.toJSONString(manager) + "成功！");
        System.out.println("----------------update test-----------------");
        manager = managerDAO.getManagerByEmail("xxx@outlook.com");
        manager.setManagerName("---------------------");
        managerDAO.updateManager(manager);
        manager = managerDAO.getManagerByEmail("xxx@outlook.com");
        System.out.println("更改" + JSON.toJSONString(manager) + "信息成功！");
        System.out.println("----------------delete test-----------------");
        managerDAO.deleteManagerByEmail("xxx@outlook.com");
        System.out.println("删除成功！");
    }

    @Test
    void jsonTest() {
        try {
            Manager manager = managerDAO.getManagerByEmail("ericzya@outlook.com");
            String s = JSON.toJSONString(manager);
            System.out.println(s);
            JSONObject jsonObject = JSONObject.parseObject(s);
            String accountPassword = jsonObject.getString("accountPassword");
            String emailAddress = jsonObject.getString("emailAddress");
            System.out.println(accountPassword + "--" + emailAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
