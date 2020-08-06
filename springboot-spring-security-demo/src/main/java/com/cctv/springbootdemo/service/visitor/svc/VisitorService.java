package com.cctv.springbootdemo.service.visitor.svc;

import com.cctv.springbootdemo.service.visitor.bo.VisitorBO;

/**
 * @Author: Eric
 * @Date: 2020/2/9 18:53
 */
public interface VisitorService {
    /**
     * 获取对应登陆者
     *
     * @param inputEmail 邮箱
     * @return VisitorBO 对应登陆账号
     */
    VisitorBO getVisitorBO(String inputEmail);

    /**
     * login check
     *
     * @param inputEmail    邮箱
     * @param inputPassword 邮箱密码
     * @return true-登陆成功 false-登陆失败
     */
    boolean loginCheck(String inputEmail, String inputPassword);

}
