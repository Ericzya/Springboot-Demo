package com.cctv.springbootmultipledatasourcedemo.service.manager.util;

import com.cctv.springbootmultipledatasourcedemo.persistent.manager.po.Manager;
import com.cctv.springbootmultipledatasourcedemo.service.manager.bo.ManagerBO;

import java.util.Arrays;

/**
 * @Author: Eric
 * @Date: 2020/1/27 17:45
 */
public class ManagerBOConverter {
    public ManagerBO convertManagerToManagerBO(Manager manager) {
        return new ManagerBO(manager.getManagerId(), manager.getManagerName(), Arrays.asList(manager.getManagerPower().split(";")), manager.getManagerPosition(), manager.getManagerSexuality(), manager.getAccountPassword(), manager.getEmailAddress());
    }
}
