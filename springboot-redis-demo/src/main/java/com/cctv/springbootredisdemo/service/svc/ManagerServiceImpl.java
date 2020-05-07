package com.cctv.springbootredisdemo.service.svc;

import com.alibaba.fastjson.JSONObject;
import com.cctv.springbootredisdemo.config.redis.RedisUtils;
import com.cctv.springbootredisdemo.persistent.pl.manager.ManagerDAO;
import com.cctv.springbootredisdemo.persistent.po.manager.Manager;
import com.cctv.springbootredisdemo.service.enums.RedisDataStatusEnum;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ManagerServiceImpl implements ManagerService {
    private ManagerDAO managerDAO;
    private RedisUtils redisUtils;

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
            log.info("用户" + managerEmail + "在缓存中不存在");
        } else if (expireTime == RedisDataStatusEnum.NEVER_EXPIRED.getStatus()) {
            log.info(managerEmail + "在缓存中永不过时");
        } else if (expireTime >= RedisDataStatusEnum.NORMAL.getStatus()) {
            log.info(redisUtils.getTime(managerEmail) + "seconds 剩余过期时间！");
        }
        if (redisUtils.hasKey(managerEmail)) {
            targetManager = JSONObject.parseObject((String) redisUtils.get(managerEmail), Manager.class);
            if (targetManager.getAccountPassword().equals(inputPassword)) {
                result = true;
            }
            log.info("从缓存中获取了用户！");
        } else {
            try {
                targetManager = managerDAO.getManagerByEmail(managerEmail);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (targetManager == null) {
                log.info("未找到对应用户！");
                return false;
            }
            redisUtils.remove(managerEmail);
            redisUtils.set(managerEmail, JSONObject.toJSONString(targetManager), Long.parseLong("60"));
            result = true;
            log.info("将对应用户存入缓存！");
        }
        return result;
    }

    @Override
    @CachePut(value = "manager", key = "#manager.id")
    public int insertManager(Manager manager) {
        log.info("进入insertManager方法！");
        return managerDAO.insertManager(manager);
    }

    @Override
    @Cacheable(value = "manager", key = "#email")
    public Manager getManagerByEmail(String email) {
        log.info("进入getManagerByEmail方法！");
        return managerDAO.getManagerByEmail(email);
    }

    @Override
    @CacheEvict(value = "manager", key = "#email")
    public void deleteManagerByEmail(String email) {
        log.info("进入deleteManagerByEmail方法！");
        managerDAO.deleteManagerByEmail(email);
    }

    @Override
    @Cacheable(value = "manager", key = "#id")
    public Manager getManagerById(Integer id) {
        log.info("进入getManagerById方法！");
        return managerDAO.getManagerById(id);
    }

    @Override
    @CacheEvict(value = "manager", key = "#id")
    public void deleteManagerById(Integer id) {
        log.info("进入deleteManagerById方法！");
        managerDAO.deleteManagerById(id);
    }
}
