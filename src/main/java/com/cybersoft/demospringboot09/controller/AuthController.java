package com.cybersoft.demospringboot09.controller;

import com.cybersoft.demospringboot09.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn() {
        User user = new User();
        user.setUsername("cybersoft");
        user.setPassword("123456");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
