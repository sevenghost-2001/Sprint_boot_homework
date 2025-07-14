package com.cybersoft.demospringboot09.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    /*
        Tham số truyền trên URL:GET
        Tham số truyền ngầm: POST, PUT, DELETE
        Tham số đóng vai trò là một đường dẫn: All(POST, PUT, DELETE)

        @RequestParam: Tùy theo phương thức sử dụng sprint boot sẽ tự động chuyển đổi kiểu dữ liệu
     */

    @GetMapping
    public ResponseEntity<?> getAllUsers(@RequestParam String username,@RequestParam String password) {
        // Logic to retrieve all users
        return ResponseEntity.ok().body("List of users with username: " + username + " and password: " + password);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestParam String email,@RequestParam String password) {
        // Logic to create a new user
        return ResponseEntity.status(201).body("User created successfully" + " with email: " + email + " and password: " + password);
    }
    @PutMapping
    public ResponseEntity<?> updateUser() {
        // Logic to update user with given id
        return ResponseEntity.ok().body(" updated successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id,@RequestParam String reason) {
        return ResponseEntity.ok().body(" deleted successfully"+ " with id: " + id + " and reason: " + reason);
    }

}
