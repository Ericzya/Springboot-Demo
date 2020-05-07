package com.cctv.springbootredisdemo.persistent.pl.manager;

import com.cctv.springbootredisdemo.persistent.po.manager.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Eric
 * @Date: 2020/1/14 18:10
 */
public interface ManagerDAO {

    /**
     * 创建管理员
     *
     * @param targetManager 新增管理员
     * @return 是否成功
     */
    int insertManager(@Param("entity") Manager targetManager);

    /**
     * 删除管理员
     *
     * @param id 管理员id
     * @return 是否成功
     */
    boolean deleteManagerById(@Param("id") Integer id);

    /**
     * 删除管理员
     *
     * @param email 管理员邮箱
     * @return 是否成功
     */
    boolean deleteManagerByEmail(String email);

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
    Manager getManagerByEmail(@Param("emailAddress") String emailAddress);

    /**
     * login check
     *
     * @param id 管理员id
     * @return Manager 对应管理员
     */
    Manager getManagerById(@Param("id") Integer id);

    /**
     * 获取管理员列表
     *
     * @return Manager 对应管理员
     */
    List<Manager> getManagerList();
}
