package com.cctv.springbootspringsecuritydemo.service.manager.svc;

import com.cctv.springbootspringsecuritydemo.persistent.manager.pl.ManagerDAO;
import com.cctv.springbootspringsecuritydemo.persistent.manager.po.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Eric
 * @Date: 2020/1/9 20:42
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    final ManagerDAO managerDAO;

    @Autowired(required = false)
    public ManagerServiceImpl(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @Override
    public boolean loginCheck(String managerEmail, String inputPassword) {
        Manager targetManager = managerDAO.getManagerByEmail(managerEmail);
        return targetManager != null && targetManager.getAccountPassword().equals(inputPassword);
    }
}
