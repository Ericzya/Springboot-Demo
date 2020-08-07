package com.cctv.springbootdemo.service.visitor.util;

import com.cctv.springbootdemo.model.po.manager.Manager;
import com.cctv.springbootdemo.model.po.user.User;
import com.cctv.springbootdemo.config.enums.PowerEnum;
import com.cctv.springbootdemo.model.vo.VisitorVO;
import com.cctv.springbootdemo.service.visitor.bo.VisitorBO;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * @Author: Eric
 * @Date: 2020/1/30 12:47
 */
public class VisitorUtil {
    public static VisitorBO convertVisitorVoToBo(VisitorVO visitorVO) {
        return new VisitorBO(visitorVO.getInputAccount(), visitorVO.getInputPassword());
    }

    public static VisitorBO convertManagerToVisitorBO(Manager manager) {
        return new VisitorBO(manager.getManagerId(), manager.getManagerName(), manager.getEmailAddress(), manager.getAccountPassword(), manager.getManagerPower(), AuthorityUtils.commaSeparatedStringToAuthorityList(manager.getManagerPower()));
    }

    public static VisitorBO convertUserToVisitor(User user) {
        return new VisitorBO(user.getUserId(), user.getUserName(), user.getUserEmail(), user.getAccountPassword(), PowerEnum.User.getCode(), AuthorityUtils.commaSeparatedStringToAuthorityList(PowerEnum.User.getCode()));
    }

}
