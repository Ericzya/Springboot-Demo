package com.cctv.springbootdemo.config.security;

import com.cctv.springbootdemo.config.enums.PowerEnum;
import com.cctv.springbootdemo.config.security.passwordencoder.McoolPasswordEncoder;
import com.cctv.springbootdemo.config.security.processhandler.SecurityAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author: Eric.Zhang
 * @Description: web url权限配置
 * @ProjectName: springboot-demo-spring-security
 * @Date: 2020/7/30 17:25
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler;
    private final UserDetailsService mcoolUserDetailsService;
    private final McoolPasswordEncoder mcoolPasswordEncoder;

    @Autowired
    public WebSecurityConfig(SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler, @Qualifier("mcoolUserDetailsServiceImpl") UserDetailsService mcoolUserDetailsService, McoolPasswordEncoder mcoolPasswordEncoder) {
        this.securityAuthenticationSuccessHandler = securityAuthenticationSuccessHandler;
        this.mcoolUserDetailsService = mcoolUserDetailsService;
        this.mcoolPasswordEncoder = mcoolPasswordEncoder;
    }

    /**
     * 配置拦截器
     *
     * @param httpSecurity HttpSecurity对象
     * @throws Exception 抛错
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        //profile下页面必须认证通过,其他都允许
        //允许表单登陆,登陆完跳转/index
        httpSecurity
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/index").failureUrl("/login?error=true")
                .successHandler(securityAuthenticationSuccessHandler)
                .permitAll()
                .and()
                //允许不登陆就可以访问的方法，多个用逗号分隔
                .authorizeRequests()
                .antMatchers("/profile").authenticated()
                .antMatchers("/monitor").hasRole(PowerEnum.Administrator.getCode())
                //其他请求无需授权访问
                .anyRequest().permitAll();

        //session管理
        httpSecurity.sessionManagement().invalidSessionUrl("/login");
        //单用户登录，如果有一个登录了，同一个用户在其他地方不能登录
        httpSecurity.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
        //退出时清空cookies
        httpSecurity.logout().deleteCookies("JESSIONID");
    }

    /**
     * 配置UserDetailsService和密码加密器
     *
     * @param auth 认证管理构造器
     * @throws Exception 抛错
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mcoolUserDetailsService).passwordEncoder(mcoolPasswordEncoder);
    }

}
