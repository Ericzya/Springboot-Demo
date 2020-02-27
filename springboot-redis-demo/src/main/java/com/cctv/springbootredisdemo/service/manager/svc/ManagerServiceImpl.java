package com.cctv.springbootredisdemo.service.manager.svc;

import com.cctv.springbootredisdemo.persistent.manager.pl.ManagerDAO;
import com.cctv.springbootredisdemo.persistent.manager.po.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Eric
 * @Date: 2020/1/9 20:42
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    private ManagerDAO managerDAO;

    @Autowired(required = false)
    public ManagerServiceImpl(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @Override
    public boolean loginCheck(String managerEmail, String inputPassword) {
        Manager targetManager = managerDAO.getManagerByEmail(managerEmail);
        if (targetManager != null && targetManager.getAccountPassword().equals(inputPassword)) {
            return true;
        } else {
            return false;
        }
    }
}
