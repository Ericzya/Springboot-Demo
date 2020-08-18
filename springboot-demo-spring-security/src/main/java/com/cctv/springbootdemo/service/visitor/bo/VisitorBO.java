package com.cctv.springbootdemo.service.visitor.bo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Author: Eric.Zhang
 * @Description: VisitorBO
 * @ProjectName: springboot-demo-spring-security
 * @Date: 2020/7/30 17:25
 */
public class VisitorBO implements UserDetails {
    private String userId;
    private String userName;
    private List<GrantedAuthority> grantedAuthorityList;
    private String inputEmail;
    private String inputPassword;
    private String roles;

    public VisitorBO(String inputEmail, String inputPassword) {
        this.inputEmail = inputEmail;
        this.inputPassword = inputPassword;
    }

    public VisitorBO(String userId, String userName, String inputEmail, String inputPassword, String roles, List<GrantedAuthority> grantedAuthorityList) {
        this.userId = userId;
        this.userName = userName;
        this.inputEmail = inputEmail;
        this.inputPassword = inputPassword;
        this.roles = roles;
        this.grantedAuthorityList = grantedAuthorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return inputPassword;
    }

    @Override
    public String getUsername() {
        return inputEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "VisitorBO{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", grantedAuthorityList=" + grantedAuthorityList +
                ", inputEmail='" + inputEmail + '\'' +
                ", inputPassword='" + inputPassword + '\'' +
                '}';
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }

    public String getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<GrantedAuthority> getGrantedAuthorityList() {
        return grantedAuthorityList;
    }

    public void setGrantedAuthorityList(List<GrantedAuthority> grantedAuthorityList) {
        this.grantedAuthorityList = grantedAuthorityList;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
