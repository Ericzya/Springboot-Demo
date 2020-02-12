package com.cctv.springbootmultipledatasourcedemo.persistent.manager.pl;

import com.cctv.springbootmultipledatasourcedemo.persistent.manager.po.Manager;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Eric
 * @Date: 2020/1/14 18:10
 */
@Repository
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
