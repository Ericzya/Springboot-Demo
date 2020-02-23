package com.cctv.springbootspringsecuritydemo.config.security;

import com.cctv.springbootspringsecuritydemo.config.enums.PowerEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: Eric
 * @Date: 2020/2/9 14:55
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler;

    @Autowired
    public WebSecurityConfig(SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler) {
        this.securityAuthenticationSuccessHandler = securityAuthenticationSuccessHandler;
    }

    /**
     * 安全拦截机制
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        //profile下页面必须认证通过,其他都允许
        //允许表单登陆,登陆完跳转/index
        httpSecurity
                //使用form表单post方式进行登录
                .formLogin()
                //登录页面为自定义的登录页面
                .loginPage("/login")
                //设置登录成功跳转页面，error=true控制页面错误信息的展示
                .successForwardUrl("/index").failureUrl("/login?error=true")
                .successHandler(securityAuthenticationSuccessHandler)
                .permitAll()
                .and()
                //允许不登陆就可以访问的方法，多个用逗号分隔
                .authorizeRequests().antMatchers("/test").permitAll()
                //其他的需要授权后访问
                .anyRequest().permitAll();
    }
}
