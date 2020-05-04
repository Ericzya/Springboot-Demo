package com.cctv.springbootredisdemo.service.svc;

import com.cctv.springbootredisdemo.persistent.pl.user.UserDAO;
import com.cctv.springbootredisdemo.persistent.po.user.User;
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
    public boolean loginCheck(String managerEmail, String inputPassword) {
        User targetUser = userDAO.getUserByEmail(managerEmail);
        if (targetUser != null && targetUser.getAccountPassword().equals(inputPassword)) {
            return true;
        } else {
            return false;
        }
    }
}
