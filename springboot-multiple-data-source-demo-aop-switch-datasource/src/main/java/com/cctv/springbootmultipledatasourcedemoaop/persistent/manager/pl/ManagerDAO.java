package com.cctv.springbootmultipledatasourcedemoaop.persistent.manager.pl;

import com.cctv.springbootmultipledatasourcedemoaop.config.exception.JdbcException;
import com.cctv.springbootmultipledatasourcedemoaop.persistent.manager.po.Manager;
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
     * @throws JdbcException 存储层异常
     */
    boolean insertManager(Manager targetManager) throws JdbcException;

    /**
     * 通过Id删除管理员
     *
     * @param managerAccount 管理员账号
     * @return 是否成功
     * @throws JdbcException 存储层异常
     */
    boolean deleteManagerByAccountId(String managerAccount) throws JdbcException;

    /**
     * 通过Email删除管理员
     *
     * @param emailAddress 管理员邮箱
     * @return 是否成功
     * @throws JdbcException 存储层异常
     */
    boolean deleteManagerByEmail(String emailAddress) throws JdbcException;

    /**
     * 更新管理员信息
     *
     * @param targetManager 对应管理员
     * @return 是否成功
     * @throws JdbcException 存储层异常
     */
    boolean updateManager(Manager targetManager) throws JdbcException;

    /**
     * login check
     *
     * @param emailAddress 管理员邮箱
     * @return Manager 对应管理员
     * @throws JdbcException 存储层异常
     */
    Manager getManagerByEmail(String emailAddress) throws JdbcException;

    /**
     * 获取管理员列表
     *
     * @return Manager 对应管理员
     * @throws JdbcException 存储层异常
     */
    List<Manager> getManagerList() throws JdbcException;
}
