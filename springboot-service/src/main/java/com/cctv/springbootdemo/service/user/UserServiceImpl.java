package com.cctv.springbootdemo.service.user;

import com.cctv.springbootdemo.dao.user.UserDAO;
import com.cctv.springbootdemo.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Eric.Zhang
 * @Description: UserServiceImpl
 * @ProjectName: springboot-demo
 * @Date: 2020/7/30 18:11
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired(required = false)
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return userDAO.getUserByEmail(userEmail);
    }
}

