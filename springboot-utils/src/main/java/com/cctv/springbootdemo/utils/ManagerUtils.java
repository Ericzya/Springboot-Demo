package com.cctv.springbootdemo.utils;

import com.cctv.springbootdemo.model.bo.manager.ManagerBO;
import com.cctv.springbootdemo.model.po.manager.Manager;

import java.util.Arrays;

/**
 * @Author: Eric.Zhang
 * @Description: 管理员Util类
 * @ProjectName: springboot-demo
 * @Date: 2020/7/31 9:58
 */
public class ManagerUtils {
    /**
     * manager实体转BO类
     * @param manager 管理员实体类
     * @return
     */
    public ManagerBO convertManagerToManagerBO(Manager manager) {
        return new ManagerBO(manager.getManagerId(), manager.getManagerName(), Arrays.asList(manager.getManagerPower().split(";")), manager.getManagerPosition(), manager.getManagerSexuality(), manager.getAccountPassword(), manager.getEmailAddress());
    }
}
