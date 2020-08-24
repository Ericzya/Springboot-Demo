package com.cctv.springbootdemo.config.security;


import java.util.List;

public class AClassWithProblems {
    final static String aaa;

    public static void main(String[] args) {
        for (int i = 0; i < 11111; i++) {
            System.out.println(aaa);
        }
    }

    private void aa_buzhidaoshenmefangfa() {
        List a = null;
        System.out.println(a.toString());
    }

}
