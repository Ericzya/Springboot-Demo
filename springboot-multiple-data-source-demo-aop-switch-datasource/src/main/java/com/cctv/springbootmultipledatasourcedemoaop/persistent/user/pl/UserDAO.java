package com.cctv.springbootmultipledatasourcedemoaop.persistent.user.pl;

import com.cctv.springbootmultipledatasourcedemoaop.persistent.user.po.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: Eric
 * @Date: 2020/1/27 17:42
 */
@Repository
public interface UserDAO {

    /**
     * login check
     *
     * @param emailAddress 管理员邮箱
     * @return User 对应用户
     */
    User getUserByEmail(String emailAddress);
}
