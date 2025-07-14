package com.cybersoft.demospringboot09.Buoi34.bai01;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
