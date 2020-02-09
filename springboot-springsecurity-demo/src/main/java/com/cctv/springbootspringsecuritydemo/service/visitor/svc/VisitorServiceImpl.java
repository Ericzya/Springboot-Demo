package com.cctv.springbootspringsecuritydemo.service.visitor.svc;

import com.cctv.springbootspringsecuritydemo.persistent.manager.pl.ManagerDAO;
import com.cctv.springbootspringsecuritydemo.persistent.manager.po.Manager;
import com.cctv.springbootspringsecuritydemo.persistent.user.pl.UserDAO;
import com.cctv.springbootspringsecuritydemo.persistent.user.po.User;
import com.cctv.springbootspringsecuritydemo.service.visitor.bo.VisitorBO;
import com.cctv.springbootspringsecuritydemo.service.visitor.util.VisitorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Eric
 * @Date: 2020/2/9 18:55
 */
@Service
public class VisitorServiceImpl implements VisitorService {
    final ManagerDAO managerDAO;
    final UserDAO userDAO;

    @Autowired(required = false)
    public VisitorServiceImpl(ManagerDAO managerDAO, UserDAO userDAO) {
        this.managerDAO = managerDAO;
        this.userDAO = userDAO;
    }

    @Override
    public VisitorBO getVisitorBO(String inputEmail) {
        Manager manager = managerDAO.getManagerByEmail(inputEmail);
        User user = userDAO.getUserByEmail(inputEmail);
        VisitorBO visitorBO = null;
        if (manager != null) {
            visitorBO = VisitorUtil.convertManagerToVisitorBO(manager);
        } else if (user != null) {
            visitorBO = VisitorUtil.convertUserToVisitor(user);
        }
        return visitorBO;
    }

    @Override
    public boolean loginCheck(String inputEmail, String inputPassword) {
        VisitorBO visitorBO = getVisitorBO(inputEmail);
        if (visitorBO != null && visitorBO.getInputPassword().equals(inputPassword)) {
            return true;
        }
        return false;
    }
}
