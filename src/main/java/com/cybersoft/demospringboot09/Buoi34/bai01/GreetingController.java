package com.cybersoft.demospringboot09.Buoi34.bai01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    @GetMapping
    ResponseEntity<String> greet(@RequestParam String name) {
        String greetingMessage = greetingService.sayHello(name);
        return new ResponseEntity<>(greetingMessage, HttpStatus.OK);
    }
}
