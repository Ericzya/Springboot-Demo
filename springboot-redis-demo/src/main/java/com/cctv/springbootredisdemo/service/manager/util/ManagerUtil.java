package com.cctv.springbootredisdemo.service.manager.util;

import com.cctv.springbootredisdemo.persistent.manager.po.Manager;
import com.cctv.springbootredisdemo.service.manager.bo.ManagerBO;

import java.util.Arrays;

/**
 * @Author: Eric
 * @Date: 2020/1/27 17:45
 */
public class ManagerUtil {
    public ManagerBO convertManagerToManagerBO(Manager manager) {
        return new ManagerBO(manager.getManagerId(), manager.getManagerName(), Arrays.asList(manager.getManagerPower().split(";")), manager.getManagerPosition(), manager.getManagerSexuality(), manager.getAccountPassword(), manager.getEmailAddress());
    }
}