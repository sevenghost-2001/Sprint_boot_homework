package com.cybersoft.demospringboot09.Buoi34.bai05;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    public String getWelcomeMessage(String name, String language) {
        String message = "";
        if("en".equals(language)) message = "Hello, "+ name;
        else if("vi".equals(language)) message = "Xin chào, "+ name;
        else message = "Language not supported";
        return message;
    }
}
