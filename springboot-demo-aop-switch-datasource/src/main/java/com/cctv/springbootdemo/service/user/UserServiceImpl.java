package com.cctv.springbootdemo.service.user;

import com.cctv.springbootdemo.aopswitch.config.aop.annotation.DataSourceAnnotation;
import com.cctv.springbootdemo.aopswitch.config.enums.DataSourceEnum;
import com.cctv.springbootdemo.dao.user.UserDAO;
import com.cctv.springbootdemo.model.po.user.User;
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
    @DataSourceAnnotation(DataSourceEnum.DB_User)
    public User getUserByEmail(String userEmail) {
        return userDAO.getUserByEmail(userEmail);
    }

    @Override
    @DataSourceAnnotation(DataSourceEnum.DB_User)
    public boolean loginCheck(String userEmail, String inputPassword) {
        User targetUser=userDAO.getUserByEmail(userEmail);
        return targetUser != null && targetUser.getAccountPassword().equals(inputPassword);
    }
}

