package com.cctv.springbootredisdemo;

import com.alibaba.fastjson.JSON;
import com.cctv.springbootredisdemo.config.redis.RedisUtils;
import com.cctv.springbootredisdemo.service.svc.ManagerService;
import com.cctv.springbootredisdemo.service.svc.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@Slf4j
class SpringbootRedisDemoApplicationTests {

    private ManagerService managerService;
    private UserService userService;
    private RedisUtils redisUtils;

    @Autowired(required = false)
    public SpringbootRedisDemoApplicationTests(ManagerService managerService, UserService userService, RedisUtils redisUtils) {
        this.managerService = managerService;
        this.userService = userService;
        this.redisUtils = redisUtils;
    }

    @Test
    void managerDataSource() {
        System.out.println("测试");
        System.out.println("错误管理员：" + (managerService.loginCheck("ericzya@outlook.com", "1") ? "登陆成功" : "登陆失败"));
        System.out.println("正确管理员：" + (managerService.loginCheck("ericzya@outlook.com", "112233") ? "登陆成功" : "登陆失败"));
        System.out.println("错误用户：" + (userService.loginCheck("ericzya@outlook.com", "1") ? "登陆成功" : "登陆失败"));
        System.out.println("正确用户：" + (userService.loginCheck("ericzya@outlook.com", "445566") ? "登陆成功" : "登陆失败"));
    }

    @Test
    void testRedisAddString() {
        log.info("存入string!");
        redisUtils.set("string", "value", Long.parseLong("10"));
        log.info("取出string，值为：" + redisUtils.get("string"));
    }

    @Test
    void testRedisAddHash() {
        if(redisUtils.hasKey("hash")){
            redisUtils.remove("hash");
        }
        log.info("存入hash!");
        HashMap<String, Object> targetHash = new HashMap<>();
        targetHash.put("name", "Eric");
        targetHash.put("sex", "男");
        redisUtils.hmSet("hash", targetHash);
        log.info("直接获取hash，值为：" + JSON.toJSONString(redisUtils.hmGet("hash")));
        log.info("直接获取hash key:sex，值为：" + redisUtils.getMapString("hash", "sex"));
        log.info("hash键值对数量为：" + redisUtils.hashSize("hash"));
        log.info("hash所有的键为：" + redisUtils.hashKeys("hash"));
    }

    @Test
    void testRedisAddList() {
        if(redisUtils.hasKey("list")){
            redisUtils.remove("list");
        }
        log.info("存入list!");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        redisUtils.set("list", list);


    }

}
