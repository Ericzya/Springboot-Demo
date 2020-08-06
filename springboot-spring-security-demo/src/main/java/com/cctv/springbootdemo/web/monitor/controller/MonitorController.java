package com.cctv.springbootdemo.web.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Eric
 * @Date: 2020/2/9 17:00
 */
@Controller
public class MonitorController {
    @GetMapping("/monitor")
    public String getMonitorPage() {
        return "/monitor/basic-table";
    }
}
