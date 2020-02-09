package com.cctv.springbootspringsecuritydemo.config.security;

import com.cctv.springbootspringsecuritydemo.service.visitor.bo.VisitorBO;
import com.cctv.springbootspringsecuritydemo.service.visitor.svc.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author: Eric
 * @Date: 2020/2/9 19:33
 */
@Service
public class UserDetailsImpl implements UserDetailsService {

    private VisitorService visitorService;

    @Autowired
    public UserDetailsImpl(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        VisitorBO visitorBO=visitorService.getVisitorBO(s);
        if (visitorBO==null){
            throw new UsernameNotFoundException(s+"--对应用户未找到!");
        }
        return visitorBO;
    }
}
