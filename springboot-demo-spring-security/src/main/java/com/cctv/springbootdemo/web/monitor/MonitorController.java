package com.cctv.springbootdemo.web.monitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Eric.Zhang
 * @Description: 监控页Controller
 * @ProjectName: springboot-demo-spring-security
 * @Date: 2020/7/30 17:25
 */
@Controller
public class MonitorController {
    @GetMapping("/monitor")
    public String getMonitorPage() {
        return "/monitor/basic-table";
    }
}
