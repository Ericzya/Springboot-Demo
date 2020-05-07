package com.cctv.springbootredisdemo.persistent.po.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Eric
 * @Date: 2020/1/9 19:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager implements Serializable {

    private static final long serialVersionUID = 1822282459715439733L;

    /**
     * id
     */
    private Integer id;
    /**
     * 管理员账号
     */
    private String managerId;
    /**
     * 管理员名称
     */
    private String managerName;
    /**
     * 管理员权限集合
     */
    private String managerPower;
    /**
     * 管理员职位
     */
    private String managerPosition;
    /**
     * 管理员性别
     */
    private String managerSexuality;
    /**
     * 管理员账号密码
     */
    private String accountPassword;
    /**
     * 管理员邮箱
     */
    private String emailAddress;
}

