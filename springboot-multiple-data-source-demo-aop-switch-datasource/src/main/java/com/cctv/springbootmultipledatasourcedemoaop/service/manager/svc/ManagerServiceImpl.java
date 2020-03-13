package com.cctv.springbootmultipledatasourcedemoaop.service.manager.svc;

import com.cctv.springbootmultipledatasourcedemoaop.persistent.manager.pl.ManagerDAO;
import com.cctv.springbootmultipledatasourcedemoaop.persistent.manager.po.Manager;
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
        boolean result = false;
        try {
            Manager targetManager = managerDAO.getManagerByEmail(managerEmail);
            if (targetManager != null && targetManager.getAccountPassword().equals(inputPassword)) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
