package com.cctv.springbootspringsecuritydemo.web.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Eric
 * @Date: 2020/2/9 15:15
 */
@Controller
public class IndexController {
    @GetMapping("/index")
    public String getIndexPage() {
        return "index/index";
    }
}
