package com.cctv.springbootspringsecuritydemo.service.visitor.util;

import com.cctv.springbootspringsecuritydemo.config.enums.PowerEnum;
import com.cctv.springbootspringsecuritydemo.persistent.manager.po.Manager;
import com.cctv.springbootspringsecuritydemo.persistent.user.po.User;
import com.cctv.springbootspringsecuritydemo.service.visitor.bo.VisitorBO;
import com.cctv.springbootspringsecuritydemo.web.login.vo.VisitorVO;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * @Author: Eric
 * @Date: 2020/1/30 12:47
 */
public class VisitorUtil {
    public static VisitorBO convertVisitorVOToBO(VisitorVO visitorVO) {
        //TODO 完成该方法
        return new VisitorBO(visitorVO.getInputAccount(), visitorVO.getInputPassword());
    }

    public static VisitorBO convertManagerToVisitorBO(Manager manager) {
        return new VisitorBO(manager.getManagerId(), manager.getManagerName(), manager.getEmailAddress(), manager.getAccountPassword(), manager.getManagerPower(), AuthorityUtils.commaSeparatedStringToAuthorityList(manager.getManagerPower()));
    }

    public static VisitorBO convertUserToVisitor(User user) {
        return new VisitorBO(user.getUserId(), user.getUserName(), user.getUserEmail(), user.getAccountPassword(), PowerEnum.User.getCode(), AuthorityUtils.commaSeparatedStringToAuthorityList(PowerEnum.User.getCode()));
    }

}
