package com.cctv.springbootdemo.service.visitor.svc;

import com.cctv.springbootdemo.dao.manager.ManagerDAO;
import com.cctv.springbootdemo.dao.user.UserDAO;
import com.cctv.springbootdemo.model.po.manager.Manager;
import com.cctv.springbootdemo.model.po.user.User;
import com.cctv.springbootdemo.service.visitor.bo.VisitorBO;
import com.cctv.springbootdemo.service.visitor.util.VisitorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Eric
 * @Date: 2020/2/9 18:55
 */
@Service
public class VisitorServiceImpl implements VisitorService {
    private ManagerDAO managerDAO;
    private UserDAO userDAO;

    @Autowired(required = false)
    public VisitorServiceImpl(ManagerDAO managerDAO, UserDAO userDAO) {
        this.managerDAO = managerDAO;
        this.userDAO = userDAO;
    }

    public VisitorServiceImpl() {
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
