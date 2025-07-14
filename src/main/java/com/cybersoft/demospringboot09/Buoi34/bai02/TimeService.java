package com.cybersoft.demospringboot09.Buoi34.bai02;

import static java.time.LocalTime.now;

public class TimeService {
    public String getCurrentTime() {
        return now().toString();
    }
}
