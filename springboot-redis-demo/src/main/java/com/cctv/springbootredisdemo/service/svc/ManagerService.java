package com.cctv.springbootredisdemo.service.svc;

import com.cctv.springbootredisdemo.persistent.po.manager.Manager;

/**
 * @Author: Eric
 * @Date: 2020/1/9 20:42
 */
public interface ManagerService {
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
     * 根据邮箱获取管理员
     *
     * @param email 管理员邮箱
     * @return 管理员实体
     */
    Manager getManagerByEmail(String email);

    /**
     * 根据邮箱删除管理员
     *
     * @param email 管理员邮箱
     */
    void deleteManagerByEmail(String email);

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
