package com.cctv.springbootdemo.service.user;

/**
 * @Author: Eric
 * @Date: 2020/1/28 17:12
 */
public interface UserService {
    /**
     * login check
     *
     * @param managerEmail  管理员邮箱
     * @param inputPassword 管理员账号密码
     * @return boolean true-登陆成功，false-登陆失败
     */
    boolean loginCheck(String managerEmail, String inputPassword);
}
