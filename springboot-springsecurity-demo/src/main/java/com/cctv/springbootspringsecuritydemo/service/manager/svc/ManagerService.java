package com.cctv.springbootspringsecuritydemo.service.manager.svc;

import com.cctv.springbootspringsecuritydemo.persistent.manager.po.Manager;

/**
 * @Author: Eric
 * @Date: 2020/1/9 20:42
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
