package com.cybersoft.demospringboot09.Buoi34.bai02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    //Đăng ký bean TimeService với @Bean
    public TimeService timeService() {
        return new TimeService();
    }
}
