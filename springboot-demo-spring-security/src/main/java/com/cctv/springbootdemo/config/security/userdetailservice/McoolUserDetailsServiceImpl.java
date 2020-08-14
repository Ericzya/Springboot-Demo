package com.cctv.springbootdemo.config.security.userdetailservice;

import com.cctv.springbootdemo.service.visitor.bo.VisitorBO;
import com.cctv.springbootdemo.service.visitor.svc.VisitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author: Eric.Zhang
 * @Description: 加载用户资料 UserDetailService
 * @ProjectName: springboot-demo-spring-security
 * @Date: 2020/7/30 17:25
 */
@Service
public class McoolUserDetailsServiceImpl implements UserDetailsService {
    private final static Logger logger = LoggerFactory.getLogger(McoolUserDetailsServiceImpl.class);
    private final VisitorService visitorService;

    @Autowired
    public McoolUserDetailsServiceImpl(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(s)) {
            logger.error("用户名不能为空！");
            throw new UsernameNotFoundException("用户名不能为空！");
        }
        VisitorBO visitorBO = visitorService.getVisitorBO(s);
        if (visitorBO == null) {
            logger.error("用户名不存在！");
            throw new UsernameNotFoundException("用户名不存在！");
        }
        return visitorBO;
    }
}
