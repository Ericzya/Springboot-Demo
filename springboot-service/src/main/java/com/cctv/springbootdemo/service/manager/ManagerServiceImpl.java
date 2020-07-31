package com.cctv.springbootdemo.service.manager;

import com.cctv.springbootdemo.dao.manager.ManagerDAO;
import com.cctv.springbootdemo.model.manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Eric.Zhang
 * @Description: ManagerServiceImpl
 * @ProjectName: springboot-demo
 * @Date: 2020/7/30 18:06
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    private ManagerDAO managerDAO;

    @Autowired(required = false)
    public ManagerServiceImpl(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @Override
    public Manager getManagerByEmail(String managerEmail) {
        return managerDAO.getManagerByEmail(managerEmail);
    }
}
