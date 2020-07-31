package com.cctv.springbootdemo.service.manager;

import com.cctv.springbootdemo.model.manager.Manager;

/**
 * @Author: Eric.Zhang
 * @Description: ManagerService
 * @ProjectName: springboot-demo
 * @Date: 2020/7/30 17:49
 */
public interface ManagerService {
    /**
     * 通过Email获取管理员
     *
     * @param managerEmail  管理员邮箱
     * @return Manager 对应管理员
     */
    Manager getManagerByEmail(String managerEmail);
}
