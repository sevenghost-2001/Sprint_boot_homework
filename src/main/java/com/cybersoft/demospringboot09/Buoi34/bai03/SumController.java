package com.cybersoft.demospringboot09.Buoi34.bai03;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {
    @GetMapping("/sum")
    ResponseEntity<?> sum(@RequestParam int a,@RequestParam int b){
        int result = a + b;
        return ResponseEntity.ok(result);
    }
}
