package com.cctv.springbootspringsecuritydemo.service.visitor;

import com.cctv.springbootspringsecuritydemo.web.login.vo.VisitorVO;

/**
 * @Author: Eric
 * @Date: 2020/1/30 12:47
 */
public class VisitorUtil {
    public VisitorBO convertVisitorVOToBO(VisitorVO visitorVO) {
        return new VisitorBO(visitorVO.getInputAccount(), visitorVO.getInputPassword());
    }

}
