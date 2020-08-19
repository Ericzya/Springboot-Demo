package com.cctv.springbootdemo.config.security.passwordencoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author: Eric.Zhang
 * @Description: 密码加密编码器
 * @ProjectName: springboot-demo-spring-security
 * @Date: 2020/7/30 17:25
 */
@Component
public class McoolPasswordEncoder extends BCryptPasswordEncoder implements PasswordEncoder {
    /**
     * 对用户输入的密码进行加密运算
     *
     * @param charSequence 目标字符串
     * @return 加密后的密码
     */
    @Override
    public String encode(CharSequence charSequence) {
        return super.encode(charSequence);
    }

    /**
     * 匹配输入密码和数据库密码
     *
     * @param rowPassword     输入密码
     * @param encodedPassword 数据库密码
     * @return 密码是否匹配
     */
    @Override
    public boolean matches(CharSequence rowPassword, String encodedPassword) {
        return super.matches(rowPassword,encodedPassword);
    }
}
