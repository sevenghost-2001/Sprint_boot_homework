package com.cybersoft.demospringboot09.Buoi34.bai05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    @Autowired
    private WelcomeService welcomeService;

    @GetMapping("/{username}")
    ResponseEntity<?> welcome(@PathVariable String username, @RequestParam String lang) {
        String welcomeMessage = welcomeService.getWelcomeMessage(username, lang);
        return ResponseEntity.ok(welcomeMessage);
    }
}
