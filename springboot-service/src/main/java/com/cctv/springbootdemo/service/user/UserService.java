package com.cctv.springbootdemo.service.user;

import com.cctv.springbootdemo.model.user.User;

/**
 * @Author: Eric.Zhang
 * @Description: UserService类
 * @ProjectName: springboot-demo
 * @Date: 2020/7/30 18:10
 */
public interface UserService {
    /**
     * 通过Email获取用户
     *
     * @param userEmail  用户邮箱
     * @return User 对应用户
     */
    User getUserByEmail(String userEmail);
}
