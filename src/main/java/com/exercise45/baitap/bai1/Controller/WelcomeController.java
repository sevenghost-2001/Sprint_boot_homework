package com.exercise45.baitap.bai1.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class WelcomeController {
    @PostMapping
    public String welcome() {
        return "Hello World!";
    }

}
