package com.cctv.springbootdemo.service.manager;

import com.alibaba.fastjson.JSONObject;
import com.cctv.springbootdemo.config.redis.RedisUtils;
import com.cctv.springbootdemo.dao.manager.ManagerDAO;
import com.cctv.springbootdemo.enums.RedisDataStatusEnum;
import com.cctv.springbootdemo.model.po.manager.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: Eric
 * @Date: 2020/1/9 20:42
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    private static final Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);

    private final ManagerDAO managerDAO;
    private final RedisUtils redisUtils;

    @Autowired(required = false)
    public ManagerServiceImpl(ManagerDAO managerDAO, RedisUtils redisUtils) {
        this.managerDAO = managerDAO;
        this.redisUtils = redisUtils;
    }

    @Override
    public boolean loginCheck(String managerEmail, String inputPassword) {
        boolean result = false;
        Manager targetManager = null;
        //从缓存获取用户信息，若信息不存在，从表中获取，并存入缓存
        long expireTime = redisUtils.getTime(managerEmail);
        if (expireTime == RedisDataStatusEnum.UNEXIST.getStatus()) {
            logger.info("用户" + managerEmail + "在缓存中不存在");
        } else if (expireTime == RedisDataStatusEnum.NEVER_EXPIRED.getStatus()) {
            logger.info(managerEmail + "在缓存中永不过时");
        } else if (expireTime >= RedisDataStatusEnum.NORMAL.getStatus()) {
            logger.info(redisUtils.getTime(managerEmail) + "seconds 剩余过期时间！");
        }
        if (redisUtils.hasKey(managerEmail)) {
            targetManager = JSONObject.parseObject((String) redisUtils.get(managerEmail), Manager.class);
            if (targetManager.getAccountPassword().equals(inputPassword)) {
                result = true;
            }
            logger.info("从缓存中获取了用户！");
        } else {
            try {
                targetManager = managerDAO.getManagerByEmail(managerEmail);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (targetManager == null) {
                logger.info("未找到对应用户！");
                return false;
            }
            redisUtils.remove(managerEmail);
            redisUtils.set(managerEmail, JSONObject.toJSONString(targetManager), Long.parseLong("60"));
            result = true;
            logger.info("将对应用户存入缓存！");
        }
        return result;
    }

    @Override
    @CachePut(value = "manager", key = "#manager.Id")
    public Manager insertManager(Manager manager) {
        logger.info("进入insertManager方法！");
        managerDAO.insertManager(manager);
        return manager;
    }

    @Override
    public Manager getManagerByEmail(String email) {
        logger.info("进入getManagerByEmail方法！");
        return managerDAO.getManagerByEmail(email);
    }

    @Override
    public void deleteManagerByEmail(String email) {
        logger.info("进入deleteManagerByEmail方法！");
        managerDAO.deleteManagerByEmail(email);
    }

    @Override
    @Cacheable(value = "manager", key = "#Id", unless = "#result == null")
    public Manager getManagerById(Integer Id) {
        logger.info("进入getManagerById方法！");
        return managerDAO.getManagerById(Id);
    }

    @Override
    @CacheEvict(value = "manager", key = "#Id")
    public void deleteManagerById(Integer Id) {
        logger.info("进入deleteManagerById方法！");
        managerDAO.deleteManagerById(Id);
    }
}
