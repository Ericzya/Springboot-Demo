package com.cctv.springbootdemo.web.login;

import com.cctv.springbootdemo.SpringbootSpringSecurityDemoApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: Eric
 * @Date: 2020/1/30 11:42
 */
@SpringBootTest(classes = SpringbootSpringSecurityDemoApplication.class)
@RunWith(SpringRunner.class)
class LoginControllerTest {

    private String rootUrl = "http://localhost:8080/mcool";
    private TestRestTemplate template = new TestRestTemplate();

    @Test
    void jetBrainCrack() {
        long max = 100000000L;
        String str = "文和";
        for (long i = 1; i <= max; i++) {
            str = MD5(str);
            if (i % 1000 == 0) {
                System.out.println(i);
            }
        }
        System.out.println(str);
    }

    public static String MD5(String string) {

        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();

    }
}