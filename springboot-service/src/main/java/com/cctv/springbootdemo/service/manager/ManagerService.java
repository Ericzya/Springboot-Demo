package com.cctv.springbootdemo.service.manager;

import com.cctv.springbootdemo.model.po.manager.Manager;

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

    /**
     * login check
     *
     * @param managerEmail  管理员邮箱
     * @param inputPassword 管理员账号密码
     * @return boolean true-登陆成功，false-登陆失败
     */
    boolean loginCheck(String managerEmail, String inputPassword);

    /**
     * 插入管理员
     *
     * @param manager 管理员实体
     * @return 管理员实体
     */
    Manager insertManager(Manager manager);

    /**
     * 删除管理员
     *
     * @param managerEmail 管理员邮箱
     * @return 是否成功
     */
    boolean deleteManagerByEmail(String managerEmail);

    /**
     * 更新管理员信息
     *
     * @param targetManager 对应管理员
     * @return 是否成功
     */
    boolean updateManager(Manager targetManager);

    /**
     * 根据id获取管理员
     *
     * @param id 管理员id
     * @return 管理员实体
     */
    Manager getManagerById(Integer id);

    /**
     * 根据id删除管理员
     *
     * @param id 管理员id
     */
    void deleteManagerById(Integer id);
}
