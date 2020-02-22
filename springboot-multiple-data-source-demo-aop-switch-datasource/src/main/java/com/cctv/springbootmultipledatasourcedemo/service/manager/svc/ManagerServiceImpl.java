package com.cctv.springbootmultipledatasourcedemo.service.manager.svc;

import com.cctv.springbootmultipledatasourcedemo.config.aop.DataSourceAnnotation;
import com.cctv.springbootmultipledatasourcedemo.config.enums.DataSourceEnum;
import com.cctv.springbootmultipledatasourcedemo.persistent.manager.pl.ManagerDAO;
import com.cctv.springbootmultipledatasourcedemo.persistent.manager.po.Manager;
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
