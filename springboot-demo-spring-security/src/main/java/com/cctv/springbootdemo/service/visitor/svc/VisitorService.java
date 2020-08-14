package com.cctv.springbootdemo.service.visitor.svc;

import com.cctv.springbootdemo.service.visitor.bo.VisitorBO;

/**
 * @Author: Eric.Zhang
 * @Description: VisitorService
 * @ProjectName: springboot-demo-spring-security
 * @Date: 2020/7/30 17:25
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
