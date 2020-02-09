package com.cctv.springbootspringsecuritydemo.service.user.svc;

import com.cctv.springbootspringsecuritydemo.persistent.user.pl.UserDAO;
import com.cctv.springbootspringsecuritydemo.persistent.user.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Eric
 * @Date: 2020/1/28 17:12
 */
@Service
public class UserServiceImpl implements UserService {
    final UserDAO userDAO;

    @Autowired(required = false)
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return userDAO.getUserByEmail(userEmail);
    }
}
