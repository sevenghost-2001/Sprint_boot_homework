package com.cybersoft.demospringboot09.Buoi34.bai02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {
    @Autowired
    private TimeService timeService;

    @RequestMapping("/time")
    public String getCurrentTime() {
        return timeService.getCurrentTime();
    }
}
