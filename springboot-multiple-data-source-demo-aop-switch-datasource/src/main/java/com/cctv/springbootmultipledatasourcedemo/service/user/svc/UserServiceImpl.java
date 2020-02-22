package com.cctv.springbootmultipledatasourcedemo.service.user.svc;

import com.cctv.springbootmultipledatasourcedemo.config.aop.DataSourceAnnotation;
import com.cctv.springbootmultipledatasourcedemo.config.enums.DataSourceEnum;
import com.cctv.springbootmultipledatasourcedemo.persistent.user.pl.UserDAO;
import com.cctv.springbootmultipledatasourcedemo.persistent.user.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Eric
 * @Date: 2020/1/28 17:12
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired(required = false)
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @DataSourceAnnotation(DataSourceEnum.DB_User)
    public boolean loginCheck(String managerEmail, String inputPassword) {
        User targetUser = userDAO.getUserByEmail(managerEmail);
        if (targetUser != null && targetUser.getAccountPassword().equals(inputPassword)) {
            return true;
        } else {
            return false;
        }
    }
}