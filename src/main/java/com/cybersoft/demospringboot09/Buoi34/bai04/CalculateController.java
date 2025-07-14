package com.cybersoft.demospringboot09.Buoi34.bai04;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculateController {
    CalculateService calculateService = new CalculateService();
    @GetMapping("/add")
    ResponseEntity<?> add(@RequestParam int a,@RequestParam int b) {
        int result = calculateService.add(a, b);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/subtract")
    ResponseEntity<?> subtract(@RequestParam int a,@RequestParam int b) {
        int result = calculateService.subtract(a, b);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/multiply")
    ResponseEntity<?> multiply(@RequestParam int a,@RequestParam int b) {
        int result = calculateService.multiply(a, b);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/divide")
    ResponseEntity<?> divide(@RequestParam int a,@RequestParam int b) {
        try {
            double result = calculateService.divide(a, b);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
