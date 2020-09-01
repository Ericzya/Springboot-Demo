package com.cctv.springbootdemo.service.manager;

import com.cctv.springbootdemo.dao.manager.ManagerDAO;
import com.cctv.springbootdemo.model.po.manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Override
    public boolean loginCheck(String managerEmail, String inputPassword) {
        Manager targetManager = managerDAO.getManagerByEmail(managerEmail);
        return targetManager != null && targetManager.getAccountPassword().equals(inputPassword);
    }

    @Override
    @CachePut(value = "manager", key = "#manager.id")
    public Manager insertManager(Manager manager) {
        managerDAO.insertManager(manager);
        return manager;
    }

    @Override
    public boolean deleteManagerByEmail(String managerEmail) {
        return managerDAO.deleteManagerByEmail(managerEmail);
    }

    @Override
    public boolean updateManager(Manager targetManager) {
        return managerDAO.updateManager(targetManager);
    }

    @Override
    @Cacheable(value = "manager", key = "#id", unless = "#result == null")
    public Manager getManagerById(Integer id) {
        return managerDAO.getManagerById(id);
    }

    @Override
    @CacheEvict(value = "manager", key = "#id")
    public void deleteManagerById(Integer id) {
        managerDAO.deleteManagerById(id);
    }
}
