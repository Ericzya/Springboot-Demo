package com.cctv.springbootredisdemo.service.manager.svc;

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
}
