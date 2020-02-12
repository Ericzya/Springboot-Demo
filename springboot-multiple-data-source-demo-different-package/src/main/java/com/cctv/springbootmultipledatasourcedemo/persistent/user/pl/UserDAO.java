package com.cctv.springbootmultipledatasourcedemo.persistent.user.pl;

import com.cctv.springbootmultipledatasourcedemo.persistent.user.po.User;

/**
 * @Author: Eric
 * @Date: 2020/1/27 17:42
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
