package com.cctv.springbootredisdemo;

import com.alibaba.fastjson.JSON;
import com.cctv.springbootdemo.SpringbootRedisDemoApplication;
import com.cctv.springbootdemo.config.redis.RedisUtils;
import com.cctv.springbootdemo.model.po.manager.Manager;
import com.cctv.springbootdemo.service.HotTopicService;
import com.cctv.springbootdemo.service.manager.ManagerService;
import com.cctv.springbootdemo.service.user.UserService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SpringbootRedisDemoApplication.class)
@RunWith(SpringRunner.class)
class SpringbootRedisDemoApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(SpringbootRedisDemoApplicationTests.class);

    private final ManagerService managerService;
    private final UserService userService;
    private final RedisUtils redisUtils;
    private final HotTopicService hotTopicService;

    @Autowired
    public SpringbootRedisDemoApplicationTests(ManagerService managerService, UserService userService, RedisUtils redisUtils, HotTopicService hotTopicService) {
        this.managerService = managerService;
        this.userService = userService;
        this.redisUtils = redisUtils;
        this.hotTopicService = hotTopicService;
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
    void testManagerCache() {
        Manager manager = new Manager( null,"12229", "test", "", "", "M", "112233", "2@outlook.com");
        managerService.insertManager(manager);
        manager = managerService.getManagerById(manager.getId());
        logger.info("获取manager:" + manager.toString());
        logger.info("再次获取manager:" + managerService.getManagerById(manager.getId ()));
        managerService.deleteManagerById(manager.getId());
        logger.info("获取manager:" + managerService.getManagerById(manager.getId()));
    }

    @Test
    void testRedisString() {
        logger.info("存入string!");
        redisUtils.set("string", "value", Long.parseLong("10"));
        logger.info("取出string，值为：" + redisUtils.get("string"));
    }

    @Test
    void testRedisHash() {
        if (redisUtils.hasKey("hash")) {
            redisUtils.remove("hash");
        }
        logger.info("存入hash!");
        HashMap<String, Object> targetHash = new HashMap<>();
        targetHash.put("name", "Eric");
        targetHash.put("sex", "男");
        redisUtils.hmSet("hash", targetHash);
        logger.info("直接获取hash，值为：" + JSON.toJSONString(redisUtils.hmGet("hash")));
        logger.info("直接获取hash key:sex，值为：" + redisUtils.getMapString("hash", "sex"));
        logger.info("hash键值对数量为：" + redisUtils.hashSize("hash"));
        logger.info("hash所有的键为：" + redisUtils.hashKeys("hash"));
    }

    @Test
    void testRedisList() {
        if (redisUtils.hasKey("list")) {
            redisUtils.remove("list");
        }
        logger.info("存入list!");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        redisUtils.leftPushAll("list", list);
        logger.info("存入list的值为：" + JSON.toJSONString(redisUtils.range("list", 0, -1)));
        logger.info("在最左加入值0！");
        redisUtils.leftPush("list", 0);
        logger.info("现在list的值为：" + JSON.toJSONString(redisUtils.range("list", 0, -1)));
        logger.info("在最右加入值5！");
        redisUtils.rightPush("list", 5);
        logger.info("现在list的值为：" + JSON.toJSONString(redisUtils.range("list", 0, -1)));
        logger.info("在3前加入值2！");
        redisUtils.leftPush("list", 3, 2);
        logger.info("现在list的值为：" + JSON.toJSONString(redisUtils.range("list", 0, -1)));
        logger.info("获取第四个值：" + redisUtils.index("list", 3));
        logger.info("现在list共有" + redisUtils.length("list") + "个值");
    }

    @Test
    void testRedisSet() {
        if (redisUtils.hasKey("set")) {
            redisUtils.remove("set");
        }
        if (redisUtils.hasKey("adc")) {
            redisUtils.remove("adc");
        }
        logger.info("存入set!");
        Set<String> set = new HashSet<>();
        set.add("Faker");
        set.add("Rookie");
        set.add("Knight");
        redisUtils.sAdd("set", set);
        logger.info("现在set共有：" + redisUtils.sMembers("set"));
        logger.info("现在set共有" + redisUtils.sSize("set") + "个值");
        Set<String> set1 = new HashSet<>();
        set1.add("Faker");
        set1.add("Uzi");
        redisUtils.sAdd("adc", set1);
        logger.info("现在set 'adc'共有：" + redisUtils.sMembers("adc"));
        logger.info("两个set交集为：" + JSON.toJSONString(redisUtils.sIntersectAndStore("set", "adc")));
    }

    @Test
    void testRedisZSet() {
        if (redisUtils.hasKey("zSet")) {
            redisUtils.remove("zSet");
        }
        if (redisUtils.hasKey("adc")) {
            redisUtils.remove("adc");
        }
        logger.info("存入zSet!");
        redisUtils.zAdd("zSet", "Faker", 10.0);
        redisUtils.zAdd("zSet", "Rookie", 8.0);
        redisUtils.zAdd("zSet", "Knight", 9.0);
        logger.info("现在Knight排第" + (redisUtils.zRank("zSet", "Knight") + 1) + "名！");
    }

    @Test
    void testCacheBreakDown() {
        HotTopicTestThread thread = new HotTopicTestThread();
        for (int i = 0; i < 999; i++) {
            thread.run();
            if (i % 25 == 0) {
                redisUtils.remove("ImSoHot");
            }
        }
    }

    class HotTopicTestThread implements Runnable {
        @Override
        public void run() {
            hotTopicService.getHotTopic();
        }
    }

}
