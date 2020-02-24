package com.cctv.springbootspringsecuritydemo.config.security.userdetailservice;

import com.cctv.springbootspringsecuritydemo.service.visitor.bo.VisitorBO;
import com.cctv.springbootspringsecuritydemo.service.visitor.svc.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author: Eric
 * @Date: 2020/2/9 19:33
 */
@Service
public class McoolUserDetailsService implements UserDetailsService {

    private VisitorService visitorService;

    @Autowired
    public McoolUserDetailsService(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(s)) {
            throw new UsernameNotFoundException("用户名不能为空！");
        }
        VisitorBO visitorBO = visitorService.getVisitorBO(s);
        if (visitorBO == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        return visitorBO;
    }
}
