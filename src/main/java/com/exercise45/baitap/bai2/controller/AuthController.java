package com.exercise45.baitap.bai2.controller;

import com.exercise45.baitap.bai2.DTO.Request.UserRequest;
import com.exercise45.baitap.bai2.DTO.Response.UserResponse;
import com.exercise45.baitap.bai2.services.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserServices userServices;



    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest request) {
        UserResponse userResponse = userServices.createUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(userResponse);
    }

    // Đăng nhập -> trả về JWT
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest request) {
        String token = userServices.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(token);
    }
}
