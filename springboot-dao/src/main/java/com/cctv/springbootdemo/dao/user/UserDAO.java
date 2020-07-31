package com.cctv.springbootdemo.dao.user;

import com.cctv.springbootdemo.model.po.user.User;

/**
 * @Author: Eric.Zhang
 * @Description: UserDAO类
 * @ProjectName: springboot-demo
 * @Date: 2020/7/30 17:31
 */
public interface UserDAO {
    /**
     * login check
     *
     * @param emailAddress 管理员邮箱
     * @return User 对应用户
     */
    User getUserByEmail(String emailAddress);
}
