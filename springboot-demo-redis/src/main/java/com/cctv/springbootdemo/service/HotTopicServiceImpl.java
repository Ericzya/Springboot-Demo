package com.cctv.springbootdemo.service;

import com.cctv.springbootdemo.config.redis.RedisUtils;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: HotTopicServiceImpl
 * @Description: 测试缓存击穿ServiceImpl
 * @Author: Eric.Zhang
 * @Date: 2020/5/9 15:44
 * @version: 1.0
 */
@Service
public class HotTopicServiceImpl implements HotTopicService {

    private static final Logger logger = LoggerFactory.getLogger(HotTopicService.class);

    private static final Lock REENTRANT_LOCK = new ReentrantLock();

    private final RedisUtils redisUtils;

    private Integer count = 0;

    @Autowired
    public HotTopicServiceImpl(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Override
    public String getHotTopic() {
        String result;
        result = redisUtils.get("ImSoHot") != null ? redisUtils.get("ImSoHot").toString() : null;
        if (Strings.isBlank(result)) {
            logger.info("这是第" + count + "次去库中查数据！");
            try {
                if (REENTRANT_LOCK.tryLock()) {
                    //假装去库里查数据
                    count++;
                    result = "Hot Dam";
                    redisUtils.set("ImSoHot", result);
                    logger.info("重新从库中获取了数据！");
                } else {
                    Thread.sleep(100L);
                    getHotTopic();
                }
            } catch (InterruptedException e) {
                logger.error("防热点数据击穿发生错误！" + e.getMessage());
                e.printStackTrace();
            }
        }
        return result;
    }
}
