package com.cctv.springbootspringsecuritydemo.config.security;

import com.cctv.springbootspringsecuritydemo.config.enums.PowerEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

/**
 * @Author: Eric
 * @Date: 2020/2/9 14:55
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 安全拦截机制
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        //profile下页面必须认证通过,其他都允许
        //允许表单登陆,登陆完跳转/index
        httpSecurity.authorizeRequests()
                .antMatchers("/profile").authenticated()
                .antMatchers("/monitor").hasRole(PowerEnum.Administrator.getCode())
                .anyRequest().permitAll()
                .and()
                .formLogin()
//                .loginPage("/login")
                .failureForwardUrl("/login")
                .successForwardUrl("/index");
    }




}
