package com.cctv.springbootdemo.dao.manager;

import com.cctv.springbootdemo.model.manager.Manager;

import java.util.List;

/**
 * @Author: Eric.Zhang
 * @Description: ManagerDAO类
 * @ProjectName: springboot-demo
 * @Date: 2020/7/30 17:25
 */
public interface ManagerDAO {
    /**
     * 创建管理员
     *
     * @param targetManager 新增管理员
     * @return 是否成功
     */
    boolean insertManager(Manager targetManager);

    /**
     * 删除管理员
     *
     * @param managerAccount 管理员账号
     * @return 是否成功
     */
    boolean deleteManagerByAccountId(String managerAccount);

    /**
     * 更新管理员信息
     *
     * @param targetManager 对应管理员
     * @return 是否成功
     */
    boolean updateManager(Manager targetManager);

    /**
     * login check
     *
     * @param emailAddress 管理员邮箱
     * @return Manager 对应管理员
     */
    Manager getManagerByEmail(String emailAddress);

    /**
     * 获取管理员列表
     *
     * @return Manager 对应管理员
     */
    List<Manager> getManagerList();
}
