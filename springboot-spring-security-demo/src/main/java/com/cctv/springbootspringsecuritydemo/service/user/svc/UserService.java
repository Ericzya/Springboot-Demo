package com.cctv.springbootspringsecuritydemo.service.user.svc;

import com.cctv.springbootspringsecuritydemo.persistent.user.po.User;

/**
 * @Author: Eric
 * @Date: 2020/1/28 17:12
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
