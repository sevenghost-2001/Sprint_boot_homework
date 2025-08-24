package com.exercise45.baitap.bai2.controller;

import com.exercise45.baitap.bai2.DTO.Response.UserResponse;
import com.exercise45.baitap.bai2.Utils.JwtUtil;
import com.exercise45.baitap.bai2.entity.Users;
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
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserServices userService,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userServices = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestParam String username,@RequestParam String password) {
        UserResponse userResponse = userServices.createUser(username, password);
        return ResponseEntity.ok(userResponse);
    }

    // Đăng nhập -> trả về JWT
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPasswords())
        );

        String token = jwtUtil.generateToken(user.getUsername());
        return ResponseEntity.ok(token);
    }
}
